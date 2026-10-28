package GRlibPackage;

public class GRlib_axis_t {
    public String spec;
    public double min;
    public double max;
    public double tick;
    public double org;
    public double position;
    public int major_count;
    public int num_ticks;
    public GRlib_tick_t[] ticks;
    public double tick_size;
    public int num_tick_labels;
    public GRlib_tick_label_t[] tick_labels;
    public double label_position;
    public int draw_axis_line;
    public int label_orientation;
    
    public GRlib_axis_t(
        String spec,
        double min,
        double max,
        double tick,
        double org,
        double position,
        int major_count,
        int num_ticks,
        GRlib_tick_t[] ticks,
        double tick_size,
        int num_tick_labels,
        GRlib_tick_label_t[] tick_labels,
        double label_position,
        int draw_axis_line,
        int label_orientation
    ) {
        this.spec = spec;
        this.min = min;
        this.max = max;
        this.tick = tick;
        this.org = org;
        this.position = position;
        this.major_count = major_count;
        this.num_ticks = num_ticks;
        this.ticks = ticks;
        this.tick_size = tick_size;
        this.num_tick_labels = num_tick_labels;
        this.tick_labels = tick_labels;
        this.label_position = label_position;
        this.draw_axis_line = draw_axis_line;
        this.label_orientation = label_orientation;
    }
}
