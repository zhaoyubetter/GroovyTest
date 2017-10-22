package gui

import groovy.swing.SwingBuilder
import org.junit.Test

import javax.swing.*
import java.awt.*

/**
 * Created by zhaoyu on 2017/10/22.
 */
class EventTest {

    static void main(args) {
        def sb = new SwingBuilder()

        def okHandler = {
            println('ok button pressed')
        }
        def cancelHandler = {
            println('cancel button pressed')
        }

        def buttons = [['ok', okHandler], ['cancel', cancelHandler]]

        // 按钮容器
        def buttonPanel = {
            sb.panel(constraints: BorderLayout.SOUTH) {
                buttons.each { but ->
                    sb.button(text: but[0], actionPerformed: but[1])
                }
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
