package gui

import groovy.swing.SwingBuilder
import org.junit.Test

import javax.swing.*
import java.awt.*

/**
 * Created by zhaoyu on 2017/10/22.
 */
class BorderLayoutTest {

    static void main(args) {
        def sb = new SwingBuilder()

        // 按钮容器
        def buttonPanel = {
            sb.panel(constraints: BorderLayout.SOUTH) {
                button(text: 'ok', actionPerformed: {
                    println('ok button pressed')
                })
                button(text: 'cancel', actionPerformed: {
                    println('cancel button pressed')
                })
            }
        }

        // 主容器，组合来布局
        def mainPanel = {
            sb.panel(layout: new BorderLayout()) {
                label(text: 'BorderLayout', horizontalAlignment: JLabel.CENTER)
                buttonPanel()
            }
        }

        def frame = sb.frame(title: 'Test1',
                location: [100, 100],
                size: [500, 300],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
            mainPanel()     // 执行主容器闭包，实现与GridLayoutTest1一样的效果
        }


        frame.pack()
        frame.setVisible(true)
    }

    // 构建简单窗体
    @Test
    void test1() {

    }
}
