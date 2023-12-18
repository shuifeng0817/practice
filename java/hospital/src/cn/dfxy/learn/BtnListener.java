package cn.dfxy.learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements ActionListener {
    DepartmentSet departmentSet = new DepartmentSet();
    DoctorSet doctorSet = new DoctorSet();
    ConsultationInformationSet consultationInformationSet = new ConsultationInformationSet();

    InformationDisplay informationDisplay = new InformationDisplay();

    AppointmentFunction appointmentFunction = new AppointmentFunction();

    SearchFunction searchFunction = new SearchFunction();

    QueryFunction queryFunction =new QueryFunction();

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnText = btn.getText();
        if (btnText.equals("科室管理")) {
            departmentSet.departmentInterface();
        } else if (btnText.equals("增加科室")) {
            departmentSet.departmentAdd();
        } else if (btnText.equals("查看科室")) {
            departmentSet.departmentSeek();
        } else if (btnText.equals("删除科室")) {
            departmentSet.departmentDelete();
        } else if (btnText.equals("修改科室")) {
            departmentSet.departmentUpdate();
        }
        if (btnText.equals("医生管理")) {
            doctorSet.doctorInterface();
        } else if (btnText.equals("增加医生")) {
            doctorSet.doctorAdd();
        } else if (btnText.equals("查看医生")) {
            doctorSet.doctorSeek();
        } else if (btnText.equals("删除医生")) {
            doctorSet.doctorDelete();
        } else if (btnText.equals("修改医生")) {
            doctorSet.doctorUpdate();
        }
        if (btnText.equals("坐诊信息设置")) {
            consultationInformationSet.consultationInterface();
        } else if (btnText.equals("查看坐诊信息")) {
            consultationInformationSet.consultationSeek();
        } else if (btnText.equals("修改坐诊信息")) {
            consultationInformationSet.consultationUpdate();
        }
        if (btnText.equals("全部信息展示")) {
            informationDisplay.departmentClassification();
        }
        if (btnText.equals("预约功能")) {
            appointmentFunction.patientInformation();
        }
        if (btnText.equals("搜索功能")) {
            searchFunction.search();
        }
        if (btnText.equals("查询功能")){
        queryFunction.function();
        }

    }

}
