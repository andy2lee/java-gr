import GRlibPackage.*;
import static GRlibPackage.GRlib.*;
import java.util.Scanner;

public class App {
    static double arr_find_max(double[] y, int n) {
        double max = 0;
        for (int i = 0; i < n; i++) {
            if (max < y[i])
                max = y[i];
        }

        return max;
    }
    public static void main(String[] args) {
        double view_height = 0.1;
        double view_width = 0.15;
        int x_ticks_num = 6;
        int y_ticks_num = 8;

        double x[] = {0.0, 0.2, 0.4, 0.6, 0.8, 1.0};
        double y[] = {0.3, 0.5, 0.4, 0.2, 0.6, 0.7};

        int x_cnt = x.length;
        double y_max = arr_find_max(y, x_cnt);

        gr_setwsviewport(0, view_width, 0, view_height);
        gr_setviewport(0.1, 0.9, 0.1, 0.9);
        gr_setwindow(0.0, 1.0, 0.0, y_max);
        gr_setcharheight(0.018);

        GRlib_tick_t[] x_ticks_arr = {
            new GRlib_tick_t(0.0, 1),
            new GRlib_tick_t(0.2, 1),
            new GRlib_tick_t(0.4, 1),
            new GRlib_tick_t(0.6, 1),
            new GRlib_tick_t(0.8, 1),
            new GRlib_tick_t(1.0, 1),
        };

        GRlib_tick_label_t[] x_labels_arr = {
            new GRlib_tick_label_t(0.0, "0.0", 0),
            new GRlib_tick_label_t(0.2, "0.2", 0),
            new GRlib_tick_label_t(0.4, "0.4", 0),
            new GRlib_tick_label_t(0.6, "0.6", 0),
            new GRlib_tick_label_t(0.8, "0.8", 0),
            new GRlib_tick_label_t(1.0, "1.0", 0),
        };

        GRlib_tick_t[] y_ticks_arr = {
            new GRlib_tick_t(0.0, 1),
            new GRlib_tick_t(0.1, 1),
            new GRlib_tick_t(0.2, 1),
            new GRlib_tick_t(0.3, 1),
            new GRlib_tick_t(0.4, 1),
            new GRlib_tick_t(0.5, 1),
            new GRlib_tick_t(0.6, 1),
            new GRlib_tick_t(0.7, 1),
        };

        GRlib_tick_label_t[] y_labels_arr = {
            new GRlib_tick_label_t(0.0, "0.0", 0),
            new GRlib_tick_label_t(0.1, "0.1", 0),
            new GRlib_tick_label_t(0.2, "0.2", 0),
            new GRlib_tick_label_t(0.3, "0.3", 0),
            new GRlib_tick_label_t(0.4, "0.4", 0),
            new GRlib_tick_label_t(0.5, "0.5", 0),
            new GRlib_tick_label_t(0.6, "0.6", 0),
            new GRlib_tick_label_t(0.7, "0.7", 0),
        };

        GRlib_axis_t x_axis = new GRlib_axis_t(
            "X",
            0.0,
            1.0,
            0.2,
            0,
            0.0,
            1,
            x_ticks_num,
            x_ticks_arr,
            0.01,
            6,
            x_labels_arr,
            -0.01,
            1,
            0
        );

        GRlib_axis_t y_axis = new GRlib_axis_t(
            "Y",
            0.0,
            0.7,
            0.1,
            0,
            0.0,
            1,
            y_ticks_num,
            y_ticks_arr,
            0.01,
            8,
            y_labels_arr,
            0.01,
            1,
            0
        );

        gr_setlinewidth(1);
        gr_drawaxes(x_axis, y_axis, 0x7);
        gr_setlinecolorind(989);

        gr_setlinewidth(1);
        gr_polyline(x_cnt, x, y);
        
        new Scanner(System.in).nextLine();
    }    
}
