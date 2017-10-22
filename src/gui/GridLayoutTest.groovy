package gui

import groovy.swing.SwingBuilder
import org.junit.Test

import javax.swing.JLabel
import javax.swing.WindowConstants
import java.awt.GridLayout

/**
 * Created by zhaoyu on 2017/10/22.
 */
class GridLayoutTest {

    static void main(args) {
        def sb = new SwingBuilder()
        def frame = sb.frame(title: 'Test1',
                location: [100, 100],
                size: [500, 300],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
            panel(layout: new GridLayout(3, 2, 5, 5)) {
                label(text: 'Last Name:', horizontalAlignment: JLabel.RIGHT)
                textField(text: '', columns: 10)
                label(text: 'Middle Name:', horizontalAlignment: JLabel.RIGHT)
                textField(text: '', columns: 10)
                label(text: 'First Name:', horizontalAlignment: JLabel.RIGHT)
                textField(text: '', columns: 10)
            }
        }

        frame.pack()
        frame.setVisible(true)
    }

    // 构建简单窗体
    @Test
    void test1() {

    }
}
