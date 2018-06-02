package org.com.view;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.com.entity.User;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ViewPDF extends AbstractPdfView {
    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String fileName = "用户信息.pdf"; // 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition",
                "attachment; filename=" + new String(fileName.getBytes(), "iso8859-1"));
        List<User> userList;
        userList = (List<User>) map.get("userList");
        BaseFont bfChinese = BaseFont.createFont("C://Windows//Fonts//simfang.ttf", BaseFont.IDENTITY_H,
                BaseFont.NOT_EMBEDDED);

        com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            String value = "ID: " + user.getdId() + "姓名: " + user.getdName() + ",密码: " + user.getdPass() + ",年龄: "
                    + user.getdAge()+",性别: " + user.getdSex();
            document.add(new Paragraph(value, FontChinese));
        }
    }
}
