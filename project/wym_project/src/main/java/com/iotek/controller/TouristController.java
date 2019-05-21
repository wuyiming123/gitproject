package com.iotek.controller;

import com.iotek.model.*;
import com.iotek.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TouristController {
    @Resource
    private TouristService touristService;
    @Resource
    private ResumService resumService;
    @Resource
    private StaffDetailService staffDetailService;
    @Resource
    private StaffService staffService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private InterviewService interviewService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private CheckWorkService checkWorkService;

    @RequestMapping("toindex")
    public String toindex(){
        return "../../index";
    }

    @RequestMapping("tohello")
    public String tohello(){
        return "hello";
    }

    @RequestMapping("login")
    public String login(String name, String pass, HttpSession session,String who,HttpServletResponse response, HttpServletRequest request)throws Exception{
//        System.err.println("admin?:"+request.getParameter("admin"));
        PrintWriter out = response.getWriter();
        if(who.equals("游客")){
            Tourist tourist = new Tourist();
            tourist.setT_name(name);
            tourist.setT_pass(pass);
            Tourist T = touristService.getTouristByNAMEAndPASS(tourist);
            if(T!=null){
                Integer t_id = T.getT_id();
                List<Delivery> deliveries = deliveryService.queryDeBytid(t_id);
                session.setAttribute("deliveries",deliveries);
                List<Delivery> deliveries1 = deliveryService.queryDeBytid_state(t_id, 2);
                session.setAttribute("deliveries1",deliveries1);
                System.out.println(T);
                session.setAttribute("tourist",T);
                return "hello";
            }
            else {
                out.flush();
                out.println("<script>");
                out.println("alert('账号或者密码错误');");
                out.println("history.back();");
                out.println("</script>");
                return "../../index";
            }
        }else if(who.equals("员工")){
            Staff staff = new Staff();
            staff.setS_sid(name);
            staff.setS_spass(pass);
            Staff stafflogin = staffService.Stafflogin(staff);
            Integer s_sdid = stafflogin.getS_sdid();
            if(stafflogin!=null){
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                Date date1 = formatter.parse("09:00:00");
                Date date2 = formatter.parse("12:00:00");

                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);//年
                int month=cal.get(Calendar.MONTH)+1;//月
                int day=cal.get(Calendar.DATE);//日
                String y = String.valueOf(year);
                String mon = String.valueOf(month);
                String d = String.valueOf(day);
                String ymd = y+"-"+mon+"-"+d;
                Integer aaa = stafflogin.getS_sdid();
                CheckWork checkWork = new CheckWork();
                checkWork.setCw_date(ymd);
                checkWork.setCw_sdid(aaa);
                int newhour = cal.get(Calendar.HOUR_OF_DAY);

                System.err.println(newhour-9);

                if(newhour<9){
                    checkWork.setCw_state(0);
                    List<CheckWork> checkWork1 = checkWorkService.foundTodayCheckWork(checkWork);
                    if(!checkWork1.isEmpty()){
                        session.setAttribute("time",0);
                        session.setAttribute("ready_to_work",0);
                    }
                    session.setAttribute("time",0);
                }

                if(newhour>=9){
                    checkWork.setCw_state(666);
                    List<CheckWork> checkWork1 = checkWorkService.foundTodayCheckWork(checkWork);
                    checkWork.setCw_state(0);
                    List<CheckWork> checkWork2 = checkWorkService.foundTodayCheckWork(checkWork);
                    if(checkWork1.isEmpty() && checkWork2.isEmpty()){
                        if((newhour-9)>=3){
                            session.setAttribute("time",1);
                            session.setAttribute("ready_to_home",999);
                        }else if(3>=(newhour-9)){
                            session.setAttribute("time",666);
                        }
                    }else if(!checkWork2.isEmpty()){
                        session.setAttribute("time",0);
                        session.setAttribute("ready_to_work",0);
                    }else if(!checkWork1.isEmpty()){
                        session.setAttribute("time",666);
                        session.setAttribute("WTF",666);
                    }
                }
                if(newhour>18){
                    checkWork.setCw_state(0);
                    List<CheckWork> checkWork1 = checkWorkService.foundTodayCheckWork(checkWork);
                    checkWork.setCw_state(1);
                    List<CheckWork> checkWork2 = checkWorkService.foundTodayCheckWork(checkWork);
                    checkWork.setCw_state(666);
                    List<CheckWork> checkWork3 = checkWorkService.foundTodayCheckWork(checkWork);
                     if(!checkWork1.isEmpty() && checkWork2.isEmpty()){
                        session.setAttribute("time",1);
                    }else if(!checkWork3.isEmpty() && checkWork2.isEmpty()){
                        session.setAttribute("time",1);
                    }else if(!checkWork3.isEmpty()){
                        session.setAttribute("time",1);
                        session.setAttribute("ready_to_home",1);
                    }
                }
                StaffDetail staffDetail = staffDetailService.foundDetailBySD_ID(s_sdid);
                session.setAttribute("staff",stafflogin);
                session.setAttribute("staffDetail",staffDetail);
                Integer sd_deid = staffDetail.getSd_deid();
                Integer sd_poid = staffDetail.getSd_poid();
                Departement departement = departmentService.queryThisDepart(sd_deid);
                Position position = positionService.queryPositionBypoid(sd_poid);
                position.getPo_name();
                session.setAttribute("dename",departement.getDe_name());
                session.setAttribute("poname",position.getPo_name());
                return "staff";
            }else {
                out.flush();
                out.println("<script>");
                out.println("alert('账号或者密码错误');");
                out.println("history.back();");
                out.println("</script>");
                return "../../index";
            }
        }
        return "../../index";
    }

    @RequestMapping("regiest")
    public String regiest(String name, String pass, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Tourist tourist = new Tourist();
        tourist.setT_name(name);
        tourist.setT_pass(pass);
        if(touristService.getTouristByName(name)!=null){
            out.flush();
            out.println("<script>");
            out.println("alert('该账号已有人注册');");
            out.println("history.back();");
            out.println("</script>");
            return "../../index";
        }if(touristService.getTouristByName(name)==null){
            touristService.addTourist(tourist);
            return "hello";
        }return "../../index";
    }

    @RequestMapping("myresume")
    public String myresume(Integer tid,HttpSession session)throws Exception{
        System.out.println(tid);
        List<Resume> resumes = resumService.allResumByTid(tid);
        session.setAttribute("myresum",resumes);
        System.out.println(resumes);
        return "myresume";
    }

    @RequestMapping("addresume")
    public String addresumefirst(Resume resume,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        System.out.println(resume);
        String r_birthday = resume.getR_birthday();
        resume.setR_birthday(r_birthday);

        boolean b = resumService.addResume(resume);
        if(b!=false){
            out.flush();
            out.println("<script>");
            out.println("alert('简历创建成功');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
        else {
            out.flush();
            out.println("<script>");
            out.println("alert('简历创建失败');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
    }

    @RequestMapping("sumdetail")
    public String sumdetail(Integer rid,HttpSession session, HttpServletResponse response)throws Exception{
        Resume resumByID = resumService.getResumByID(rid);
        session.setAttribute("thisresume",resumByID);
        return "thisresume";
    }

    @RequestMapping("updateresume")
    public String updateresume(Resume resume,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        boolean b = resumService.updateResume(resume);
        Integer r_id = resume.getR_id();
        if(b){
            Resume resumByID = resumService.getResumByID(r_id);
            session.setAttribute("thisresume",resumByID);
            out.flush();
            out.println("<script>");
            out.println("alert('简历修改成功');");
            out.println("history.back();");
            out.println("</script>");
            return "thisresume";
        }else {
            out.flush();
            out.println("<script>");
            out.println("alert('简历修改失败');");
            out.println("history.back();");
            out.println("</script>");
            return "thisresume";
        }
    }

    @RequestMapping("delthisresume")
    public String delthisresume(Integer rid,HttpSession session, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        if(rid!=null){
            boolean b = resumService.delThisResume(rid);
            if(b!=false){
                Resume resumByID = resumService.getResumByID(rid);
                Integer r_tid = resumByID.getR_tid();
                List<Resume> resumes = resumService.allResumByTid(r_tid);
                session.setAttribute("myresum",resumes);
                out.flush();
                out.println("<script>");
                out.println("alert('删除成功');");
                out.println("history.back();");
                out.println("</script>");
                return "myresume";
            }else {
                out.flush();
                out.println("<script>");
                out.println("alert('删除失败');");
                out.println("history.back();");
                out.println("</script>");
                return "myresume";
            }
        }else {
            out.flush();
            out.println("<script>");
            out.println("alert('错误编码：XD1810');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
    }

    @RequestMapping("delivery")
    public String delivery(HttpSession session,Integer ri_id,Integer t_id,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        List<Resume> resumes = resumService.allResumByTid(t_id);
        Recruit recruit = recruitService.getRecruit(ri_id);
        if(deliveryService.founddelivery(t_id,ri_id)!=null){
            out.flush();
            out.println("<script>");
            out.println("alert('莫要重复投递简历');");
            out.println("history.back();");
            out.println("</script>");
            return "hello";
        }
        session.setAttribute("resums",resumes);
        session.setAttribute("thisrecruit",recruit);
        return "deliver";
    }

    @RequestMapping("myinterview")
    public String myinterview(HttpSession session)throws Exception{
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        List<Resume> resumes = resumService.queryAllResume();
        session.setAttribute("allrecruit",allRecruit);
        session.setAttribute("resumes",resumes);
        return "myinterview";
    }

    @RequestMapping("thisinterview")
    public String thisinterview(Integer id,HttpSession session,HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        Delivery delivery = deliveryService.fountDeliByid(id);
        session.setAttribute("thisdeli",delivery);
        Integer d_rid = delivery.getD_rid();
        Integer d_riid = delivery.getD_riid();
        Integer d_id = delivery.getD_id();
        InterView interView = interviewService.queryIntByid(d_id);
        Recruit recruit = recruitService.getRecruit(d_riid);
        Resume resumByID = resumService.getResumByID(d_rid);
        session.setAttribute("thisrecruit",recruit);
        session.setAttribute("thisresume",resumByID);
        session.setAttribute("thisinterview",interView);
        String r_name = resumByID.getR_name();
        StaffDetail staffDetail = staffDetailService.fountDetailByT_NAME(r_name);
        Integer sd_id = staffDetail.getSd_id();
        Staff staff = staffService.foundStaffByS_SDID(sd_id);
        session.setAttribute("staff",staff);
        if(interView.getI_state()==1){
            out.flush();
            out.println("<script>");
            out.println("alert('对方还没回复您的简历呢，请再耐心等一等吧！');");
            out.println("history.back();");
            out.println("</script>");
            return "myinterview";
        }
        return "thisinterview";
    }

    @RequestMapping("ido")
    public String ido(Integer iid,HttpSession session)throws Exception{
        InterView interView = interviewService.queryIntByi_id(iid);
        interView.setI_state(666);///666代表游客接受面试邀请
        interviewService.updateState_666(interView);
        Integer i_did = interView.getI_did();
        Delivery delivery = deliveryService.fountDeliByid(i_did);
        delivery.setD_state(666);
        deliveryService.updateDeli(delivery);
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        List<Resume> resumes = resumService.queryAllResume();
        session.setAttribute("allrecruit",allRecruit);
        session.setAttribute("resumes",resumes);
        Integer d_tid = delivery.getD_tid();
        List<Delivery> deliveries = deliveryService.queryDeBytid(d_tid);
        session.setAttribute("deliveries",deliveries);
        List<Delivery> deliveries1 = deliveryService.queryDeBytid_state(d_tid, 2);
        session.setAttribute("deliveries1",deliveries1);
        return "myinterview";
    }

    @RequestMapping("donot")
    public String donot(Integer iid,HttpSession session)throws Exception{
        InterView interView = interviewService.queryIntByi_id(iid);
        interView.setI_state(555);///666代表游客接受面试邀请
        interviewService.updateState_666(interView);
        Integer i_did = interView.getI_did();
        Delivery delivery = deliveryService.fountDeliByid(i_did);
        delivery.setD_state(555);
        deliveryService.updateDeli(delivery);
        List<Recruit> allRecruit = recruitService.getAllRecruit();
        List<Resume> resumes = resumService.queryAllResume();
        session.setAttribute("allrecruit",allRecruit);
        session.setAttribute("resumes",resumes);
        Integer d_tid = delivery.getD_tid();
        List<Delivery> deliveries = deliveryService.queryDeBytid(d_tid);
        session.setAttribute("deliveries",deliveries);
        List<Delivery> deliveries1 = deliveryService.queryDeBytid_state(d_tid, 2);
        session.setAttribute("deliveries1",deliveries1);
        return "myinterview";
    }
}




































