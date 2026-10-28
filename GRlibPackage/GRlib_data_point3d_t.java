package GRlibPackage;

public class GRlib_data_point3d_t {
    public GRlib_point3d_t pt;
    public double data;

    public GRlib_data_point3d_t(
        GRlib_point3d_t pt,
        double data
    ) {
        this.pt = pt;
        this.data = data;
    }
}
