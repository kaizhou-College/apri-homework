<%@ page import="java.util.*,java.awt.*" pageEncoding="GBK"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="java.awt.Graphics"%>
<%@ page import="java.awt.Color"%>
<%@ page import="java.awt.Font"%>
<%@ page import="javax.imageio.ImageIO"%>
<%

	// ͼƬ�Ŀ�ȡ�
   	int width=160;
    // ͼƬ�ĸ߶ȡ�
	int height=40;
    // ��֤���ַ�����
    int codeCount = 4;
    // ��֤���������
    int lineCount = 150;
    // ��֤��
    String code = null;
    // ��֤��ͼƬBuffer
    BufferedImage buffImg = null;
    
	// ��֤�뷶Χ,ȥ��0(����)��O(ƴ��)���׻�����(Сд��1��LҲ����ȥ��,��д������)
	char[] codeSequence={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	//���������֤��
	StringBuffer randomCode=new StringBuffer();
	
	int x = 0, fontHeight = 0, codeY = 0;
    int red = 0, green = 0, blue = 0;

    x = width / (codeCount + 2);//ÿ���ַ��Ŀ��(���Ҹ��ճ�һ���ַ�)
    fontHeight = height - 2;//����ĸ߶�
    codeY = height - 4;
    
    // ͼ��buffer
    buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    //�ڻ��������ɻ���
    Graphics2D g = buffImg.createGraphics();
    //Graphics g=buffImg.getGraphics();
    // ���������
    Random random = new Random();
    // ��ͼ�����Ϊ��ɫ
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    // ��������,�����޸�Ϊ������
    Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
//  Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);
    g.setFont(font);

    //������ĸ����ߣ������ʼ�������ɫ
    for (int i = 0; i < lineCount; i++) {
        // ���������ʼ�ͽ�������
        int xs = random.nextInt(width);//x���꿪ʼ
        int ys = random.nextInt(height);//y���꿪ʼ
        int xe = xs + random.nextInt(width / 8);//x�������
        int ye = ys + random.nextInt(height / 8);//y�������

         // �����������ɫֵ���������ÿ�������ߵ���ɫֵ������ͬ��
         red = random.nextInt(255);
         green = random.nextInt(255);
         blue = random.nextInt(255);
         g.setColor(new Color(red, green, blue));
         g.drawLine(xs, ys, xe, ye);
    }

    // �������codeCount���ַ�����֤�롣
    for (int i = 0; i < codeCount; i++) {
         String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
         // �����������ɫֵ���������ÿ���ַ�����ɫֵ������ͬ��
         red = random.nextInt(255);
         green = random.nextInt(255);
         blue = random.nextInt(255);
         g.setColor(new Color(red, green, blue));
         g.drawString(strRand, (i + 1) * x, codeY);
         // ���������ĸ�����������һ��
         randomCode.append(strRand);
     }
    
     // ����λ���ֵ���֤�뱣�浽Session�С�
     code = randomCode.toString();
     randomCode = null;
     //�Ѳ�������֤��浽session��
     session.setAttribute("code",code);
	 g.dispose();
	 //����������������ΪͼƬ,���ҷ��͸��ͻ���IE
	 ServletOutputStream os=response.getOutputStream();
	 ImageIO.write(buffImg,"JPEG",os);
	 os.flush();
	
	
	 out.clear();
	 out = pageContext.pushBody();
	
 %>




