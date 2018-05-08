package com.ziv.example.jweb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月30日   下午2:16:20 
 * 类说明 :
 * 		将网页嵌入JFrame中
 * 
*/
public class JWebFrame extends JPanel {
	private static final long serialVersionUID = 1L;  
	
	private JPanel webBrowserPanel;
    private JWebBrowser webBrowser;
	public JWebFrame(String url) {
        super(new BorderLayout());  
        webBrowserPanel = new JPanel(new BorderLayout());  
        webBrowser = new JWebBrowser();  
        webBrowser.navigate(url);
        webBrowser.setButtonBarVisible(false);
        webBrowser.setMenuBarVisible(false);  
        webBrowser.setBarsVisible(false);  
        webBrowser.setStatusBarVisible(false);
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);  
        add(webBrowserPanel, BorderLayout.CENTER);
    }
	
	public JWebBrowser getWebBrowser() {
		return webBrowser;
	}
    
	public static void createWeb(String url) {
		createWeb(url,null);
	}
	
    public static void createWeb(String url,String title) {
        UIUtils.setPreferredLookAndFeel();
        NativeInterface.open();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {  
            	JWebFrame jWebFrame = new JWebFrame(url);
                JFrame frame = new JFrame(title);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(jWebFrame, BorderLayout.CENTER);  
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setLocationByPlatform(true);
                frame.setMinimumSize(new Dimension(800,600));
                
                ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("ziv.ico"));
                System.out.println(imgIcon.getImage().getSource());
                frame.setIconImage(imgIcon.getImage());
                frame.setVisible(true);
                
                frame.addWindowListener(new WindowAdapter() {
                	@Override
                	public void windowClosing(WindowEvent e) {
                		super.windowClosing(e);
                		System.out.println("--close DISPOSE_ON_CLOSE--");
                	}
                });
            }  
        });  
        NativeInterface.runEventPump();
    }

	public static void main(String[] args) {
        JWebFrame.createWeb("http://www.baidu.com");
    }  
  
}
 