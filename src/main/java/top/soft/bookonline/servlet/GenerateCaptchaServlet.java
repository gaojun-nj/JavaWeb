package top.soft.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 86189
 * @description: TODO
 * @date 2024/11/16 18:24
 */
@WebServlet("/generate-captcha")
public class GenerateCaptchaServlet extends HttpServlet {
    // 验证码图片的宽度
    private static final int WIDTH = 120;
    // 验证码图片的高度
    private static final int HEIGHT = 25;
    // 验证码字符个数
    private static final int CODE_LENGTH = 4;
    // 干扰线的数量
    private static final int LINE_COUNT = 5;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一个BufferedImage对象，指定图像类型为RGB
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // 获取图像的绘图上下文
        Graphics g = image.getGraphics();

        // 设置背景颜色为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 设置字体
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);

        // 设置文本颜色为黑色
        g.setColor(Color.BLACK);

        // 生成随机验证码字符串
        String captchaCode = generateCaptchaCode();

        // 将验证码字符串存储到Session中，用于后续验证
        req.getSession().setAttribute("captchaCode", captchaCode);

        // 在图像上绘制验证码字符
        for (int i = 0; i < CODE_LENGTH; i++) {
            g.drawString(captchaCode.charAt(i) + "", (i * 20) + 10, 20);
        }

        // 绘制干扰线
        drawRandomLines(g);

        // 释放图形上下文资源
        g.dispose();

        // 设置响应头，指定内容类型为图像格式（这里是PNG）
        resp.setContentType("image/png");

        // 将生成的图像以PNG格式输出到响应流中
        ImageIO.write(image, "png", resp.getOutputStream());
    }

    // 生成随机验证码字符串的方法
    private String generateCaptchaCode() {
        Random random = new Random();
        StringBuilder captchaCode = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomAscii = random.nextInt(26) + 65; // 生成A-Z的随机ASCII码
            captchaCode.append((char) randomAscii);
        }
        return captchaCode.toString();
    }

    // 绘制干扰线的方法
    private void drawRandomLines(Graphics g) {
        Random random = new Random();
        for (int i = 0; i < LINE_COUNT; i++) {
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);

            g.setColor(getRandomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    // 获取随机颜色的方法
    private Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

}

