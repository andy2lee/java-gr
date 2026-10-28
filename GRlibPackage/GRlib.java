package GRlibPackage;

import static java.lang.foreign.ValueLayout.ADDRESS;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;

public class GRlib {

    public static final Arena ARENA = Arena.ofConfined();
    public static final Linker LINKER = Linker.nativeLinker();
    public static SymbolLookup LIBGRUI = null;

    static final StructLayout ticks_t_Layout = MemoryLayout.structLayout(
      ValueLayout.JAVA_DOUBLE.withName("value"),
      ValueLayout.JAVA_INT.withName("is_major"),
      MemoryLayout.paddingLayout(4)
    );

    static final StructLayout ticks_label_t_Layout = MemoryLayout.structLayout(
      ValueLayout.JAVA_DOUBLE.withName("tick"),
      ValueLayout.ADDRESS.withName("label"),
      ValueLayout.JAVA_DOUBLE.withName("width")
    );

    static final StructLayout axis_t_Layout = MemoryLayout.structLayout(
      ValueLayout.ADDRESS.withName("spec"),
      ValueLayout.JAVA_DOUBLE.withName("min"),
      ValueLayout.JAVA_DOUBLE.withName("max"),
      ValueLayout.JAVA_DOUBLE.withName("tick"),
      ValueLayout.JAVA_DOUBLE.withName("org"),
      ValueLayout.JAVA_DOUBLE.withName("position"),
      ValueLayout.JAVA_INT.withName("major_count"),
      ValueLayout.JAVA_INT.withName("num_ticks"),
      ValueLayout.ADDRESS.withName("ticks"),
      ValueLayout.JAVA_DOUBLE.withName("tick_size"),
      ValueLayout.JAVA_INT.withName("num_tick_labels"),
      MemoryLayout.paddingLayout(4),
      ValueLayout.ADDRESS.withName("tick_labels"),
      ValueLayout.JAVA_DOUBLE.withName("label_position"),
      ValueLayout.JAVA_INT.withName("draw_axis_line"),
      ValueLayout.JAVA_INT.withName("label_orientation")
    );

    static final StructLayout vertex_t_Layout = MemoryLayout.structLayout(
      ValueLayout.JAVA_DOUBLE.withName("x"),
      ValueLayout.JAVA_DOUBLE.withName("y")
    );

    static final StructLayout point3d_t_Layout = MemoryLayout.structLayout(
      ValueLayout.JAVA_DOUBLE.withName("x"),
      ValueLayout.JAVA_DOUBLE.withName("y"),
      ValueLayout.JAVA_DOUBLE.withName("z")
    );

    static final StructLayout data_point3d_t_Layout = MemoryLayout.structLayout(
      ValueLayout.ADDRESS.withName("pt"),
      ValueLayout.JAVA_DOUBLE.withName("data")
    );

    static final StructLayout format_reference_t_Layout = MemoryLayout.structLayout(
      ValueLayout.JAVA_INT.withName("scientific"),
      ValueLayout.JAVA_INT.withName("decimal_digits")
    );

    public static MethodHandle gr_initgr;
    public static MethodHandle gr_debug;
    public static MethodHandle gr_opengks;
    public static MethodHandle gr_closegks;
    public static MethodHandle gr_inqdspsize;
    public static MethodHandle gr_openws;
    public static MethodHandle gr_closews;
    public static MethodHandle gr_activatews;
    public static MethodHandle gr_deactivatews;
    public static MethodHandle gr_configurews;
    public static MethodHandle gr_clearws;
    public static MethodHandle gr_updatews;
    public static MethodHandle gr_polyline;
    public static MethodHandle gr_polymarker;
    public static MethodHandle gr_text;
    public static MethodHandle gr_textx;
    public static MethodHandle gr_inqtext;
    public static MethodHandle gr_inqtextx;
    public static MethodHandle gr_fillarea;
    public static MethodHandle gr_cellarray;
    public static MethodHandle gr_nonuniformcellarray;
    public static MethodHandle gr_polarcellarray;
    public static MethodHandle gr_nonuniformpolarcellarray;
    public static MethodHandle gr_gdp;
    public static MethodHandle gr_spline;
    public static MethodHandle gr_gridit;
    public static MethodHandle gr_setlinetype;
    public static MethodHandle gr_inqlinetype;
    public static MethodHandle gr_setlinewidth;
    public static MethodHandle gr_inqlinewidth;
    public static MethodHandle gr_setlinecolorind;
    public static MethodHandle gr_inqlinecolorind;
    public static MethodHandle gr_setmarkertype;
    public static MethodHandle gr_inqmarkertype;
    public static MethodHandle gr_setmarkersize;
    public static MethodHandle gr_inqmarkersize;
    public static MethodHandle gr_setmarkercolorind;
    public static MethodHandle gr_inqmarkercolorind;
    public static MethodHandle gr_settextfontprec;
    public static MethodHandle gr_setcharexpan;
    public static MethodHandle gr_setcharspace;
    public static MethodHandle gr_settextcolorind;
    public static MethodHandle gr_inqtextcolorind;
    public static MethodHandle gr_setcharheight;
    public static MethodHandle gr_setwscharheight;
    public static MethodHandle gr_inqcharheight;
    public static MethodHandle gr_setcharup;
    public static MethodHandle gr_settextpath;
    public static MethodHandle gr_settextalign;
    public static MethodHandle gr_setfillintstyle;
    public static MethodHandle gr_inqfillintstyle;
    public static MethodHandle gr_setfillstyle;
    public static MethodHandle gr_inqfillstyle;
    public static MethodHandle gr_setfillcolorind;
    public static MethodHandle gr_inqfillcolorind;
    public static MethodHandle gr_setresizebehaviour;
    public static MethodHandle gr_inqresizebehaviour;
    public static MethodHandle gr_setcolorrep;
    public static MethodHandle gr_setwindow;
    public static MethodHandle gr_inqwindow;
    public static MethodHandle gr_setviewport;
    public static MethodHandle gr_inqviewport;
    public static MethodHandle gr_selntran;
    public static MethodHandle gr_setclip;
    public static MethodHandle gr_setwswindow;
    public static MethodHandle gr_setwsviewport;
    public static MethodHandle gr_createseg;
    public static MethodHandle gr_copysegws;
    public static MethodHandle gr_redrawsegws;
    public static MethodHandle gr_setsegtran;
    public static MethodHandle gr_closeseg;
    public static MethodHandle gr_samplelocator;
    public static MethodHandle gr_emergencyclosegks;
    public static MethodHandle gr_updategks;
    public static MethodHandle gr_setspace;
    public static MethodHandle gr_inqspace;
    public static MethodHandle gr_setscale;
    public static MethodHandle gr_inqscale;
    public static MethodHandle gr_textext;
    public static MethodHandle gr_inqtextext;
    public static MethodHandle gr_setscientificformat;
    public static MethodHandle gr_axes;
    public static MethodHandle gr_axeslbl;
    public static MethodHandle gr_axis;
    public static MethodHandle gr_drawaxis;
    public static MethodHandle gr_drawaxes;
    public static MethodHandle gr_freeaxis;
    public static MethodHandle gr_grid;
    public static MethodHandle gr_grid3d;
    public static MethodHandle gr_verrorbars;
    public static MethodHandle gr_herrorbars;
    public static MethodHandle gr_polyline3d;
    public static MethodHandle gr_polymarker3d;
    public static MethodHandle gr_axes3d;
    public static MethodHandle gr_titles3d;
    public static MethodHandle gr_settitles3d;
    public static MethodHandle gr_surface;
    public static MethodHandle gr_contour;
    public static MethodHandle gr_contourf;
    public static MethodHandle gr_tricontour;
    public static MethodHandle gr_hexbin;
    public static MethodHandle gr_hexbin_2pass;
    public static MethodHandle gr_setcolormap;
    public static MethodHandle gr_inqcolormap;
    public static MethodHandle gr_setcolormapfromrgb;
    public static MethodHandle gr_inqcolormapinds;
    public static MethodHandle gr_colorbar;
    public static MethodHandle gr_inqcolor;
    public static MethodHandle gr_inqcolorfromrgb;
    public static MethodHandle gr_hsvtorgb;
    public static MethodHandle gr_tick;
    public static MethodHandle gr_validaterange;
    public static MethodHandle gr_adjustlimits;
    public static MethodHandle gr_adjustrange;
    public static MethodHandle gr_beginprint;
    public static MethodHandle gr_beginprintext;
    public static MethodHandle gr_endprint;
    public static MethodHandle gr_ndctowc;
    public static MethodHandle gr_wctondc;
    public static MethodHandle gr_wc3towc;
    public static MethodHandle gr_drawrect;
    public static MethodHandle gr_fillrect;
    public static MethodHandle gr_drawarc;
    public static MethodHandle gr_fillarc;
    public static MethodHandle gr_drawpath;
    public static MethodHandle gr_setarrowstyle;
    public static MethodHandle gr_setarrowsize;
    public static MethodHandle gr_drawarrow;
    public static MethodHandle gr_readimage;
    public static MethodHandle gr_drawimage;
    public static MethodHandle gr_importgraphics;
    public static MethodHandle gr_setshadow;
    public static MethodHandle gr_settransparency;
    public static MethodHandle gr_inqtransparency;
    public static MethodHandle gr_setcoordxform;
    public static MethodHandle gr_begingraphics;
    public static MethodHandle gr_endgraphics;
    public static MethodHandle gr_getgraphics;
    public static MethodHandle gr_drawgraphics;
    public static MethodHandle gr_startlistener;
    public static MethodHandle gr_mathtex;
    public static MethodHandle gr_inqmathtex;
    public static MethodHandle gr_mathtex3d;
    public static MethodHandle gr_inqmathtex3d;
    public static MethodHandle gr_beginselection;
    public static MethodHandle gr_endselection;
    public static MethodHandle gr_setbboxcallback;
    public static MethodHandle gr_cancelbboxcallback;
    public static MethodHandle gr_moveselection;
    public static MethodHandle gr_resizeselection;
    public static MethodHandle gr_inqbbox;
    public static MethodHandle gr_precision;
    public static MethodHandle gr_text_maxsize;
    public static MethodHandle gr_setregenflags;
    public static MethodHandle gr_inqregenflags;
    public static MethodHandle gr_savestate;
    public static MethodHandle gr_restorestate;
    public static MethodHandle gr_savecontext;
    public static MethodHandle gr_selectcontext;
    public static MethodHandle gr_destroycontext;
    public static MethodHandle gr_unselectcontext;
    public static MethodHandle gr_uselinespec;
    public static MethodHandle gr_delaunay;
    public static MethodHandle gr_reducepoints;
    public static MethodHandle gr_trisurface;
    public static MethodHandle gr_gradient;
    public static MethodHandle gr_quiver;
    public static MethodHandle gr_interp2;
    public static MethodHandle gr_version;
    public static MethodHandle gr_shade;
    public static MethodHandle gr_shadepoints;
    public static MethodHandle gr_shadelines;
    public static MethodHandle gr_panzoom;
    public static MethodHandle gr_findboundary;
    public static MethodHandle gr_setresamplemethod;
    public static MethodHandle gr_inqresamplemethod;
    public static MethodHandle gr_path;
    public static MethodHandle gr_setborderwidth;
    public static MethodHandle gr_inqborderwidth;
    public static MethodHandle gr_setbordercolorind;
    public static MethodHandle gr_inqbordercolorind;
    public static MethodHandle gr_selectclipxform;
    public static MethodHandle gr_inqclipxform;
    public static MethodHandle gr_setprojectiontype;
    public static MethodHandle gr_inqprojectiontype;
    public static MethodHandle gr_setperspectiveprojection;
    public static MethodHandle gr_inqperspectiveprojection;
    public static MethodHandle gr_settransformationparameters;
    public static MethodHandle gr_inqtransformationparameters;
    public static MethodHandle gr_setorthographicprojection;
    public static MethodHandle gr_inqorthographicprojection;
    public static MethodHandle gr_camerainteraction;
    public static MethodHandle gr_setwindow3d;
    public static MethodHandle gr_inqwindow3d;
    public static MethodHandle gr_setscalefactors3d;
    public static MethodHandle gr_inqscalefactors3d;
    public static MethodHandle gr_setspace3d;
    public static MethodHandle gr_inqspace3d;
    public static MethodHandle gr_text3d;
    public static MethodHandle gr_inqtext3d;
    public static MethodHandle gr_settextencoding;
    public static MethodHandle gr_inqtextencoding;
    public static MethodHandle gr_loadfont;
    public static MethodHandle gr_setcallback;
    public static MethodHandle gr_setthreadnumber;
    public static MethodHandle gr_setpicturesizeforvolume;
    public static MethodHandle gr_setvolumebordercalculation;
    public static MethodHandle gr_setapproximativecalculation;
    public static MethodHandle gr_inqvolumeflags;
    public static MethodHandle gr_cpubasedvolume;
    public static MethodHandle gr_cpubasedvolume_2pass;
    public static MethodHandle gr_inqvpsize;
    public static MethodHandle gr_polygonmesh3d;
    public static MethodHandle gr_volume_nogrid;
    public static MethodHandle gr_volume_interp_tri_linear_init;
    public static MethodHandle gr_volume_interp_gauss_init;
    public static MethodHandle gr_volume_interp_tri_linear;
    public static MethodHandle gr_volume_interp_gauss;
    public static MethodHandle gr_setmathfont;
    public static MethodHandle gr_inqmathfont;
    public static MethodHandle gr_setclipregion;
    public static MethodHandle gr_inqclipregion;
    public static MethodHandle gr_settextoffset;
    public static MethodHandle gr_ftoa;
    public static MethodHandle gr_getformat;

    static {
        try {
            LIBGRUI = SymbolLookup.libraryLookup("libGR", ARENA);
            gr_initgr = LINKER.downcallHandle(LIBGRUI.find("gr_initgr").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_debug = LINKER.downcallHandle(LIBGRUI.find("gr_debug").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT));
            gr_opengks = LINKER.downcallHandle(LIBGRUI.find("gr_opengks").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_closegks = LINKER.downcallHandle(LIBGRUI.find("gr_closegks").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_inqdspsize = LINKER.downcallHandle(LIBGRUI.find("gr_inqdspsize").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_openws = LINKER.downcallHandle(LIBGRUI.find("gr_openws").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_closews = LINKER.downcallHandle(LIBGRUI.find("gr_closews").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_activatews = LINKER.downcallHandle(LIBGRUI.find("gr_activatews").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_deactivatews = LINKER.downcallHandle(LIBGRUI.find("gr_deactivatews").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_configurews = LINKER.downcallHandle(LIBGRUI.find("gr_configurews").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_clearws = LINKER.downcallHandle(LIBGRUI.find("gr_clearws").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_updatews = LINKER.downcallHandle(LIBGRUI.find("gr_updatews").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_polyline = LINKER.downcallHandle(LIBGRUI.find("gr_polyline").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_polymarker = LINKER.downcallHandle(LIBGRUI.find("gr_polymarker").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_text = LINKER.downcallHandle(LIBGRUI.find("gr_text").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            gr_textx = LINKER.downcallHandle(LIBGRUI.find("gr_textx").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_inqtext = LINKER.downcallHandle(LIBGRUI.find("gr_inqtext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_inqtextx = LINKER.downcallHandle(LIBGRUI.find("gr_inqtextx").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_fillarea = LINKER.downcallHandle(LIBGRUI.find("gr_fillarea").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_cellarray = LINKER.downcallHandle(LIBGRUI.find("gr_cellarray").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_nonuniformcellarray = LINKER.downcallHandle(LIBGRUI.find("gr_nonuniformcellarray").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_polarcellarray = LINKER.downcallHandle(LIBGRUI.find("gr_polarcellarray").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_nonuniformpolarcellarray = LINKER.downcallHandle(LIBGRUI.find("gr_nonuniformpolarcellarray").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_gdp = LINKER.downcallHandle(LIBGRUI.find("gr_gdp").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_spline = LINKER.downcallHandle(LIBGRUI.find("gr_spline").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_gridit = LINKER.downcallHandle(LIBGRUI.find("gr_gridit").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setlinetype = LINKER.downcallHandle(LIBGRUI.find("gr_setlinetype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqlinetype = LINKER.downcallHandle(LIBGRUI.find("gr_inqlinetype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setlinewidth = LINKER.downcallHandle(LIBGRUI.find("gr_setlinewidth").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_inqlinewidth = LINKER.downcallHandle(LIBGRUI.find("gr_inqlinewidth").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setlinecolorind = LINKER.downcallHandle(LIBGRUI.find("gr_setlinecolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqlinecolorind = LINKER.downcallHandle(LIBGRUI.find("gr_inqlinecolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setmarkertype = LINKER.downcallHandle(LIBGRUI.find("gr_setmarkertype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqmarkertype = LINKER.downcallHandle(LIBGRUI.find("gr_inqmarkertype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setmarkersize = LINKER.downcallHandle(LIBGRUI.find("gr_setmarkersize").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_inqmarkersize = LINKER.downcallHandle(LIBGRUI.find("gr_inqmarkersize").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setmarkercolorind = LINKER.downcallHandle(LIBGRUI.find("gr_setmarkercolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqmarkercolorind = LINKER.downcallHandle(LIBGRUI.find("gr_inqmarkercolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_settextfontprec = LINKER.downcallHandle(LIBGRUI.find("gr_settextfontprec").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_setcharexpan = LINKER.downcallHandle(LIBGRUI.find("gr_setcharexpan").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_setcharspace = LINKER.downcallHandle(LIBGRUI.find("gr_setcharspace").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_settextcolorind = LINKER.downcallHandle(LIBGRUI.find("gr_settextcolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqtextcolorind = LINKER.downcallHandle(LIBGRUI.find("gr_inqtextcolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setcharheight = LINKER.downcallHandle(LIBGRUI.find("gr_setcharheight").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_setwscharheight = LINKER.downcallHandle(LIBGRUI.find("gr_setwscharheight").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqcharheight = LINKER.downcallHandle(LIBGRUI.find("gr_inqcharheight").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setcharup = LINKER.downcallHandle(LIBGRUI.find("gr_setcharup").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_settextpath = LINKER.downcallHandle(LIBGRUI.find("gr_settextpath").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_settextalign = LINKER.downcallHandle(LIBGRUI.find("gr_settextalign").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_setfillintstyle = LINKER.downcallHandle(LIBGRUI.find("gr_setfillintstyle").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqfillintstyle = LINKER.downcallHandle(LIBGRUI.find("gr_inqfillintstyle").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setfillstyle = LINKER.downcallHandle(LIBGRUI.find("gr_setfillstyle").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqfillstyle = LINKER.downcallHandle(LIBGRUI.find("gr_inqfillstyle").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setfillcolorind = LINKER.downcallHandle(LIBGRUI.find("gr_setfillcolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqfillcolorind = LINKER.downcallHandle(LIBGRUI.find("gr_inqfillcolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            // gr_setresizebehaviour = LINKER.downcallHandle(LIBGRUI.find("gr_setresizebehaviour").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            // gr_inqresizebehaviour = LINKER.downcallHandle(LIBGRUI.find("gr_inqresizebehaviour").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setcolorrep = LINKER.downcallHandle(LIBGRUI.find("gr_setcolorrep").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_setwindow = LINKER.downcallHandle(LIBGRUI.find("gr_setwindow").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqwindow = LINKER.downcallHandle(LIBGRUI.find("gr_inqwindow").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setviewport = LINKER.downcallHandle(LIBGRUI.find("gr_setviewport").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqviewport = LINKER.downcallHandle(LIBGRUI.find("gr_inqviewport").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_selntran = LINKER.downcallHandle(LIBGRUI.find("gr_selntran").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_setclip = LINKER.downcallHandle(LIBGRUI.find("gr_setclip").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_setwswindow = LINKER.downcallHandle(LIBGRUI.find("gr_setwswindow").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_setwsviewport = LINKER.downcallHandle(LIBGRUI.find("gr_setwsviewport").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_createseg = LINKER.downcallHandle(LIBGRUI.find("gr_createseg").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_copysegws = LINKER.downcallHandle(LIBGRUI.find("gr_copysegws").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_redrawsegws = LINKER.downcallHandle(LIBGRUI.find("gr_redrawsegws").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_setsegtran = LINKER.downcallHandle(LIBGRUI.find("gr_setsegtran").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_closeseg = LINKER.downcallHandle(LIBGRUI.find("gr_closeseg").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_samplelocator = LINKER.downcallHandle(LIBGRUI.find("gr_samplelocator").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_emergencyclosegks = LINKER.downcallHandle(LIBGRUI.find("gr_emergencyclosegks").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_updategks = LINKER.downcallHandle(LIBGRUI.find("gr_updategks").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_setspace = LINKER.downcallHandle(LIBGRUI.find("gr_setspace").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_inqspace = LINKER.downcallHandle(LIBGRUI.find("gr_inqspace").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setscale = LINKER.downcallHandle(LIBGRUI.find("gr_setscale").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_inqscale = LINKER.downcallHandle(LIBGRUI.find("gr_inqscale").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_textext = LINKER.downcallHandle(LIBGRUI.find("gr_textext").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            gr_inqtextext = LINKER.downcallHandle(LIBGRUI.find("gr_inqtextext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setscientificformat = LINKER.downcallHandle(LIBGRUI.find("gr_setscientificformat").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_axes = LINKER.downcallHandle(LIBGRUI.find("gr_axes").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE));
            gr_axeslbl = LINKER.downcallHandle(LIBGRUI.find("gr_axeslbl").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_axis = LINKER.downcallHandle(LIBGRUI.find("gr_axis").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_drawaxis = LINKER.downcallHandle(LIBGRUI.find("gr_drawaxis").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_drawaxes = LINKER.downcallHandle(LIBGRUI.find("gr_drawaxes").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_freeaxis = LINKER.downcallHandle(LIBGRUI.find("gr_freeaxis").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_grid = LINKER.downcallHandle(LIBGRUI.find("gr_grid").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_grid3d = LINKER.downcallHandle(LIBGRUI.find("gr_grid3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_verrorbars = LINKER.downcallHandle(LIBGRUI.find("gr_verrorbars").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_herrorbars = LINKER.downcallHandle(LIBGRUI.find("gr_herrorbars").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_polyline3d = LINKER.downcallHandle(LIBGRUI.find("gr_polyline3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_polymarker3d = LINKER.downcallHandle(LIBGRUI.find("gr_polymarker3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_axes3d = LINKER.downcallHandle(LIBGRUI.find("gr_axes3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE));
            gr_titles3d = LINKER.downcallHandle(LIBGRUI.find("gr_titles3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_settitles3d = LINKER.downcallHandle(LIBGRUI.find("gr_settitles3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_surface = LINKER.downcallHandle(LIBGRUI.find("gr_surface").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_contour = LINKER.downcallHandle(LIBGRUI.find("gr_contour").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_contourf = LINKER.downcallHandle(LIBGRUI.find("gr_contourf").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_tricontour = LINKER.downcallHandle(LIBGRUI.find("gr_tricontour").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_hexbin = LINKER.downcallHandle(LIBGRUI.find("gr_hexbin").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_hexbin_2pass = LINKER.downcallHandle(LIBGRUI.find("gr_hexbin_2pass").orElseThrow(), FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_setcolormap = LINKER.downcallHandle(LIBGRUI.find("gr_setcolormap").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqcolormap = LINKER.downcallHandle(LIBGRUI.find("gr_inqcolormap").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setcolormapfromrgb = LINKER.downcallHandle(LIBGRUI.find("gr_setcolormapfromrgb").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_inqcolormapinds = LINKER.downcallHandle(LIBGRUI.find("gr_inqcolormapinds").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_colorbar = LINKER.downcallHandle(LIBGRUI.find("gr_colorbar").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_inqcolor = LINKER.downcallHandle(LIBGRUI.find("gr_inqcolor").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_inqcolorfromrgb = LINKER.downcallHandle(LIBGRUI.find("gr_inqcolorfromrgb").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_hsvtorgb = LINKER.downcallHandle(LIBGRUI.find("gr_hsvtorgb").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_tick = LINKER.downcallHandle(LIBGRUI.find("gr_tick").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_validaterange = LINKER.downcallHandle(LIBGRUI.find("gr_validaterange").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_adjustlimits = LINKER.downcallHandle(LIBGRUI.find("gr_adjustlimits").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_adjustrange = LINKER.downcallHandle(LIBGRUI.find("gr_adjustrange").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_beginprint = LINKER.downcallHandle(LIBGRUI.find("gr_beginprint").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_beginprintext = LINKER.downcallHandle(LIBGRUI.find("gr_beginprintext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_endprint = LINKER.downcallHandle(LIBGRUI.find("gr_endprint").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_ndctowc = LINKER.downcallHandle(LIBGRUI.find("gr_ndctowc").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_wctondc = LINKER.downcallHandle(LIBGRUI.find("gr_wctondc").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_wc3towc = LINKER.downcallHandle(LIBGRUI.find("gr_wc3towc").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_drawrect = LINKER.downcallHandle(LIBGRUI.find("gr_drawrect").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_fillrect = LINKER.downcallHandle(LIBGRUI.find("gr_fillrect").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_drawarc = LINKER.downcallHandle(LIBGRUI.find("gr_drawarc").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_fillarc = LINKER.downcallHandle(LIBGRUI.find("gr_fillarc").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_drawpath = LINKER.downcallHandle(LIBGRUI.find("gr_drawpath").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_setarrowstyle = LINKER.downcallHandle(LIBGRUI.find("gr_setarrowstyle").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_setarrowsize = LINKER.downcallHandle(LIBGRUI.find("gr_setarrowsize").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_drawarrow = LINKER.downcallHandle(LIBGRUI.find("gr_drawarrow").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_readimage = LINKER.downcallHandle(LIBGRUI.find("gr_readimage").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_drawimage = LINKER.downcallHandle(LIBGRUI.find("gr_drawimage").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_importgraphics = LINKER.downcallHandle(LIBGRUI.find("gr_importgraphics").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_setshadow = LINKER.downcallHandle(LIBGRUI.find("gr_setshadow").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_settransparency = LINKER.downcallHandle(LIBGRUI.find("gr_settransparency").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_inqtransparency = LINKER.downcallHandle(LIBGRUI.find("gr_inqtransparency").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setcoordxform = LINKER.downcallHandle(LIBGRUI.find("gr_setcoordxform").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_begingraphics = LINKER.downcallHandle(LIBGRUI.find("gr_begingraphics").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_endgraphics = LINKER.downcallHandle(LIBGRUI.find("gr_endgraphics").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_getgraphics = LINKER.downcallHandle(LIBGRUI.find("gr_getgraphics").orElseThrow(), FunctionDescriptor.of(ValueLayout.ADDRESS));
            gr_drawgraphics = LINKER.downcallHandle(LIBGRUI.find("gr_drawgraphics").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_startlistener = LINKER.downcallHandle(LIBGRUI.find("gr_startlistener").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT));
            gr_mathtex = LINKER.downcallHandle(LIBGRUI.find("gr_mathtex").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            gr_inqmathtex = LINKER.downcallHandle(LIBGRUI.find("gr_inqmathtex").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_mathtex3d = LINKER.downcallHandle(LIBGRUI.find("gr_mathtex3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_inqmathtex3d = LINKER.downcallHandle(LIBGRUI.find("gr_inqmathtex3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_beginselection = LINKER.downcallHandle(LIBGRUI.find("gr_beginselection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_endselection = LINKER.downcallHandle(LIBGRUI.find("gr_endselection").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_setbboxcallback = LINKER.downcallHandle(LIBGRUI.find("gr_setbboxcallback").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_cancelbboxcallback = LINKER.downcallHandle(LIBGRUI.find("gr_cancelbboxcallback").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_moveselection = LINKER.downcallHandle(LIBGRUI.find("gr_moveselection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_resizeselection = LINKER.downcallHandle(LIBGRUI.find("gr_resizeselection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqbbox = LINKER.downcallHandle(LIBGRUI.find("gr_inqbbox").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_precision = LINKER.downcallHandle(LIBGRUI.find("gr_precision").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE));
            gr_text_maxsize = LINKER.downcallHandle(LIBGRUI.find("gr_text_maxsize").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT));
            gr_setregenflags = LINKER.downcallHandle(LIBGRUI.find("gr_setregenflags").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqregenflags = LINKER.downcallHandle(LIBGRUI.find("gr_inqregenflags").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT));
            gr_savestate = LINKER.downcallHandle(LIBGRUI.find("gr_savestate").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_restorestate = LINKER.downcallHandle(LIBGRUI.find("gr_restorestate").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_savecontext = LINKER.downcallHandle(LIBGRUI.find("gr_savecontext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_selectcontext = LINKER.downcallHandle(LIBGRUI.find("gr_selectcontext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_destroycontext = LINKER.downcallHandle(LIBGRUI.find("gr_destroycontext").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_unselectcontext = LINKER.downcallHandle(LIBGRUI.find("gr_unselectcontext").orElseThrow(), FunctionDescriptor.ofVoid());
            gr_uselinespec = LINKER.downcallHandle(LIBGRUI.find("gr_uselinespec").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_delaunay = LINKER.downcallHandle(LIBGRUI.find("gr_delaunay").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_reducepoints = LINKER.downcallHandle(LIBGRUI.find("gr_reducepoints").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_trisurface = LINKER.downcallHandle(LIBGRUI.find("gr_trisurface").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_gradient = LINKER.downcallHandle(LIBGRUI.find("gr_gradient").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_quiver = LINKER.downcallHandle(LIBGRUI.find("gr_quiver").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_interp2 = LINKER.downcallHandle(LIBGRUI.find("gr_interp2").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_DOUBLE));
            gr_version = LINKER.downcallHandle(LIBGRUI.find("gr_version").orElseThrow(), FunctionDescriptor.of(ValueLayout.ADDRESS));
            gr_shade = LINKER.downcallHandle(LIBGRUI.find("gr_shade").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
            gr_shadepoints = LINKER.downcallHandle(LIBGRUI.find("gr_shadepoints").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_shadelines = LINKER.downcallHandle(LIBGRUI.find("gr_shadelines").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_panzoom = LINKER.downcallHandle(LIBGRUI.find("gr_panzoom").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_findboundary = LINKER.downcallHandle(LIBGRUI.find("gr_findboundary").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_setresamplemethod = LINKER.downcallHandle(LIBGRUI.find("gr_setresamplemethod").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqresamplemethod = LINKER.downcallHandle(LIBGRUI.find("gr_inqresamplemethod").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_path = LINKER.downcallHandle(LIBGRUI.find("gr_path").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setborderwidth = LINKER.downcallHandle(LIBGRUI.find("gr_setborderwidth").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE));
            gr_inqborderwidth = LINKER.downcallHandle(LIBGRUI.find("gr_inqborderwidth").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setbordercolorind = LINKER.downcallHandle(LIBGRUI.find("gr_setbordercolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqbordercolorind = LINKER.downcallHandle(LIBGRUI.find("gr_inqbordercolorind").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_selectclipxform = LINKER.downcallHandle(LIBGRUI.find("gr_selectclipxform").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqclipxform = LINKER.downcallHandle(LIBGRUI.find("gr_inqclipxform").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setprojectiontype = LINKER.downcallHandle(LIBGRUI.find("gr_setprojectiontype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqprojectiontype = LINKER.downcallHandle(LIBGRUI.find("gr_inqprojectiontype").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setperspectiveprojection = LINKER.downcallHandle(LIBGRUI.find("gr_setperspectiveprojection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqperspectiveprojection = LINKER.downcallHandle(LIBGRUI.find("gr_inqperspectiveprojection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_settransformationparameters = LINKER.downcallHandle(LIBGRUI.find("gr_settransformationparameters").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqtransformationparameters = LINKER.downcallHandle(LIBGRUI.find("gr_inqtransformationparameters").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setorthographicprojection = LINKER.downcallHandle(LIBGRUI.find("gr_setorthographicprojection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqorthographicprojection = LINKER.downcallHandle(LIBGRUI.find("gr_inqorthographicprojection").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_camerainteraction = LINKER.downcallHandle(LIBGRUI.find("gr_camerainteraction").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_setwindow3d = LINKER.downcallHandle(LIBGRUI.find("gr_setwindow3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqwindow3d = LINKER.downcallHandle(LIBGRUI.find("gr_inqwindow3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setscalefactors3d = LINKER.downcallHandle(LIBGRUI.find("gr_setscalefactors3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqscalefactors3d = LINKER.downcallHandle(LIBGRUI.find("gr_inqscalefactors3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setspace3d = LINKER.downcallHandle(LIBGRUI.find("gr_setspace3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_inqspace3d = LINKER.downcallHandle(LIBGRUI.find("gr_inqspace3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_text3d = LINKER.downcallHandle(LIBGRUI.find("gr_text3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            gr_inqtext3d = LINKER.downcallHandle(LIBGRUI.find("gr_inqtext3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_settextencoding = LINKER.downcallHandle(LIBGRUI.find("gr_settextencoding").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqtextencoding = LINKER.downcallHandle(LIBGRUI.find("gr_inqtextencoding").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_loadfont = LINKER.downcallHandle(LIBGRUI.find("gr_loadfont").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setcallback = LINKER.downcallHandle(LIBGRUI.find("gr_setcallback").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setthreadnumber = LINKER.downcallHandle(LIBGRUI.find("gr_setthreadnumber").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_setpicturesizeforvolume = LINKER.downcallHandle(LIBGRUI.find("gr_setpicturesizeforvolume").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            gr_setvolumebordercalculation = LINKER.downcallHandle(LIBGRUI.find("gr_setvolumebordercalculation").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_setapproximativecalculation = LINKER.downcallHandle(LIBGRUI.find("gr_setapproximativecalculation").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqvolumeflags = LINKER.downcallHandle(LIBGRUI.find("gr_inqvolumeflags").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_cpubasedvolume = LINKER.downcallHandle(LIBGRUI.find("gr_cpubasedvolume").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_cpubasedvolume_2pass = LINKER.downcallHandle(LIBGRUI.find("gr_cpubasedvolume_2pass").orElseThrow(), FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_inqvpsize = LINKER.downcallHandle(LIBGRUI.find("gr_inqvpsize").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_polygonmesh3d = LINKER.downcallHandle(LIBGRUI.find("gr_polygonmesh3d").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_volume_nogrid = LINKER.downcallHandle(LIBGRUI.find("gr_volume_nogrid").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_DOUBLE));
            gr_volume_interp_tri_linear_init = LINKER.downcallHandle(LIBGRUI.find("gr_volume_interp_tri_linear_init").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_volume_interp_gauss_init = LINKER.downcallHandle(LIBGRUI.find("gr_volume_interp_gauss_init").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            gr_volume_interp_tri_linear = LINKER.downcallHandle(LIBGRUI.find("gr_volume_interp_tri_linear").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_volume_interp_gauss = LINKER.downcallHandle(LIBGRUI.find("gr_volume_interp_gauss").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            gr_setmathfont = LINKER.downcallHandle(LIBGRUI.find("gr_setmathfont").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqmathfont = LINKER.downcallHandle(LIBGRUI.find("gr_inqmathfont").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_setclipregion = LINKER.downcallHandle(LIBGRUI.find("gr_setclipregion").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
            gr_inqclipregion = LINKER.downcallHandle(LIBGRUI.find("gr_inqclipregion").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
            gr_settextoffset = LINKER.downcallHandle(LIBGRUI.find("gr_settextoffset").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
            gr_ftoa = LINKER.downcallHandle(LIBGRUI.find("gr_ftoa").orElseThrow(), FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_DOUBLE, ValueLayout.ADDRESS));
            gr_getformat = LINKER.downcallHandle(LIBGRUI.find("gr_getformat").orElseThrow(), FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_INT));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MemorySegment set_axis_t(GRlib_axis_t var0) {
      // MemorySegment ticks_t_memseg = ARENA.allocate(ticks_t_Layout);
      // VarHandle value_hdlr = ticks_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("value"));
      // VarHandle is_major_hdlr = ticks_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("is_major"));
      // value_hdlr.set(ticks_t_memseg, var0.ticks.value);
      // is_major_hdlr.set(ticks_t_memseg, var0.ticks.is_major);

      // MemorySegment ticks_label_t_memseg = ARENA.allocate(ticks_label_t_Layout);
      // VarHandle tick_label_hdlr = ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("tick"));
      // VarHandle label_hdlr = ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("label"));
      // VarHandle width_hdlr = ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("width"));
      // tick_label_hdlr.set(ticks_label_t_memseg, var0.tick_labels.tick);
      // label_hdlr.set(ticks_label_t_memseg, ARENA.allocateFrom(var0.tick_labels.label));
      // width_hdlr.set(ticks_label_t_memseg, var0.tick_labels.width);

      // processing ticks_t_memseg
      int ticks_len = var0.ticks.length;
      long ticks_t_Layout_size = ticks_t_Layout.byteSize();
      MemorySegment ticks_t_memseg = ARENA.allocate(ticks_t_Layout, ticks_len);
      for (int i = 0; i < ticks_len; i++) {
        MemorySegment.copy(var0.ticks[i].na_memseg, 0L, ticks_t_memseg, i * ticks_t_Layout_size, ticks_t_Layout_size);
      }

      // processing ticks_label_t_memseg
      int tick_labels_len = var0.tick_labels.length;
      long ticks_label_t_Layout_size = ticks_label_t_Layout.byteSize();
      MemorySegment ticks_label_t_memseg = ARENA.allocate(ticks_label_t_Layout, tick_labels_len);
      for (int i = 0; i < tick_labels_len; i++) {
        MemorySegment.copy(var0.tick_labels[i].na_memseg, 0L, ticks_label_t_memseg, i * ticks_label_t_Layout_size, ticks_label_t_Layout_size);
      }

      MemorySegment axis_t_memseg = ARENA.allocate(axis_t_Layout);
      VarHandle spec_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("spec"));
      VarHandle min_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("min"));
      VarHandle max_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("max"));
      VarHandle tick_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("tick"));
      VarHandle org_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("org"));
      VarHandle position_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("position"));
      VarHandle major_count_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("major_count"));
      VarHandle num_ticks_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("num_ticks"));
      VarHandle ticks_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("ticks"));
      VarHandle tick_size_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("tick_size"));
      VarHandle num_tick_labels_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("num_tick_labels"));
      VarHandle tick_labels_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("tick_labels"));
      VarHandle label_position_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("label_position"));
      VarHandle draw_axis_line_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("draw_axis_line"));
      VarHandle label_orientation_hdlr = axis_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("label_orientation"));

      spec_hdlr.set(axis_t_memseg, 0, ARENA.allocateFrom(var0.spec));
      min_hdlr.set(axis_t_memseg, 0, var0.min);
      max_hdlr.set(axis_t_memseg, 0, var0.max);
      tick_hdlr.set(axis_t_memseg, 0, var0.tick);
      org_hdlr.set(axis_t_memseg, 0, var0.org);
      position_hdlr.set(axis_t_memseg, 0, var0.position);
      major_count_hdlr.set(axis_t_memseg, 0, var0.major_count);
      num_ticks_hdlr.set(axis_t_memseg, 0, var0.num_ticks);
      ticks_hdlr.set(axis_t_memseg, 0, ticks_t_memseg);
      tick_size_hdlr.set(axis_t_memseg, 0, var0.tick_size);
      num_tick_labels_hdlr.set(axis_t_memseg, 0, var0.num_tick_labels);
      tick_labels_hdlr.set(axis_t_memseg, 0, ticks_label_t_memseg);
      label_position_hdlr.set(axis_t_memseg, 0, var0.label_position);
      draw_axis_line_hdlr.set(axis_t_memseg, 0, var0.draw_axis_line);
      label_orientation_hdlr.set(axis_t_memseg, 0, var0.label_orientation);

      return axis_t_memseg;
    }

    public static MemorySegment set_vertex_t(GRlib_vertex_t var0) {
      MemorySegment vertex_t_memseg = ARENA.allocate(vertex_t_Layout);
      VarHandle x_hdlr = vertex_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("x"));
      VarHandle y_hdlr = vertex_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("y"));
      x_hdlr.set(vertex_t_memseg, var0.x);
      y_hdlr.set(vertex_t_memseg, var0.y);

      return vertex_t_memseg;
    }

    public static MemorySegment set_format_reference_t(GRlib_format_reference_t var0) {
      MemorySegment format_reference_t_memseg = ARENA.allocate(format_reference_t_Layout);
      VarHandle scientific_hdlr = vertex_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("scientific"));
      VarHandle decimal_digits_hdlr = vertex_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("decimal_digits"));
      scientific_hdlr.set(format_reference_t_memseg, var0.scientific);
      decimal_digits_hdlr.set(format_reference_t_memseg, var0.decimal_digits);

      return format_reference_t_memseg;
    }

    public static void gr_initgr(){
      try {
        gr_initgr.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_debug(){
      try {
        return (int)gr_debug.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_opengks(){
      try {
        gr_opengks.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_closegks(){
      try {
        gr_closegks.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqdspsize(double[] var0, double[] var1, int[] var2, int[] var3){
      try {
        gr_inqdspsize.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_INT, var2), ARENA.allocateFrom(ValueLayout.JAVA_INT, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_openws(int var0, String var1, int var2){
      try {
        gr_openws.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_closews(int var0){
      try {
        gr_closews.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_activatews(int var0){
      try {
        gr_activatews.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_deactivatews(int var0){
      try {
        gr_deactivatews.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_configurews(){
      try {
        gr_configurews.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_clearws(){
      try {
        gr_clearws.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_updatews(){
      try {
        gr_updatews.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polyline(int var0, double[] var1, double[] var2){
      try {
        gr_polyline.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polymarker(int var0, double[] var1, double[] var2){
      try {
        gr_polymarker.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_text(double var0, double var1, String var2){
      try {
        gr_text.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_textx(double var0, double var1, String var2, int var3){
      try {
        gr_textx.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtext(double var0, double var1, String var2, double[] var3, double[] var4){
      try {
        gr_inqtext.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtextx(double var0, double var1, String var2, int var3, double[] var4, double[] var5){
      try {
        gr_inqtextx.invoke(var0, var1, var2, var3, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_fillarea(int var0, double[] var1, double[] var2){
      try {
        gr_fillarea.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_cellarray(double var0, double var1, double var2, double var3, int var4, int var5, int var6, int var7, int var8, int var9, int[] var10){
      try {
        gr_cellarray.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, ARENA.allocateFrom(ValueLayout.JAVA_INT, var10));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_nonuniformcellarray(double[] var0, double[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8){
      try {
        gr_nonuniformcellarray.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), var2, var3, var4, var5, var6, var7, ARENA.allocateFrom(ValueLayout.JAVA_INT, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polarcellarray(double var0, double var1, double var2, double var3, double var4, double var5, int var6, int var7, int var8, int var9, int var10, int var11, int[] var12){
      try {
        gr_polarcellarray.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, ARENA.allocateFrom(ValueLayout.JAVA_INT, var12));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_nonuniformpolarcellarray(double var0, double var1, double[] var2, double[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int[] var10){
      try {
        gr_nonuniformpolarcellarray.invoke(var0, var1, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, var5, var6, var7, var8, var9, ARENA.allocateFrom(ValueLayout.JAVA_INT, var10));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_gdp(int var0, double[] var1, double[] var2, int var3, int var4, int[] var5){
      try {
        gr_gdp.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4, ARENA.allocateFrom(ValueLayout.JAVA_INT, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_spline(int var0, double[] var1, double[] var2, int var3, int var4){
      try {
        gr_spline.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_gridit(int var0, double[] var1, double[] var2, double[] var3, int var4, int var5, double[] var6, double[] var7, double[] var8){
      try {
        gr_gridit.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, var5, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setlinetype(int var0){
      try {
        gr_setlinetype.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqlinetype(int[] var0){
      try {
        gr_inqlinetype.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setlinewidth(double var0){
      try {
        gr_setlinewidth.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqlinewidth(double[] var0){
      try {
        gr_inqlinewidth.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setlinecolorind(int var0){
      try {
        gr_setlinecolorind.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqlinecolorind(int[] var0){
      try {
        gr_inqlinecolorind.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setmarkertype(int var0){
      try {
        gr_setmarkertype.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmarkertype(int[] var0){
      try {
        gr_inqmarkertype.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setmarkersize(double var0){
      try {
        gr_setmarkersize.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmarkersize(double[] var0){
      try {
        gr_inqmarkersize.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setmarkercolorind(int var0){
      try {
        gr_setmarkercolorind.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmarkercolorind(int[] var0){
      try {
        gr_inqmarkercolorind.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextfontprec(int var0, int var1){
      try {
        gr_settextfontprec.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcharexpan(double var0){
      try {
        gr_setcharexpan.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcharspace(double var0){
      try {
        gr_setcharspace.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextcolorind(int var0){
      try {
        gr_settextcolorind.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtextcolorind(int[] var0){
      try {
        gr_inqtextcolorind.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcharheight(double var0){
      try {
        gr_setcharheight.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setwscharheight(double var0, double var1){
      try {
        gr_setwscharheight.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqcharheight(double[] var0){
      try {
        gr_inqcharheight.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcharup(double var0, double var1){
      try {
        gr_setcharup.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextpath(int var0){
      try {
        gr_settextpath.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextalign(int var0, int var1){
      try {
        gr_settextalign.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setfillintstyle(int var0){
      try {
        gr_setfillintstyle.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqfillintstyle(int[] var0){
      try {
        gr_inqfillintstyle.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setfillstyle(int var0){
      try {
        gr_setfillstyle.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqfillstyle(int[] var0){
      try {
        gr_inqfillstyle.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setfillcolorind(int var0){
      try {
        gr_setfillcolorind.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqfillcolorind(int[] var0){
      try {
        gr_inqfillcolorind.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setresizebehaviour(int var0){
      try {
        gr_setresizebehaviour.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqresizebehaviour(int[] var0){
      try {
        gr_inqresizebehaviour.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcolorrep(int var0, double var1, double var2, double var3){
      try {
        gr_setcolorrep.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setwindow(double var0, double var1, double var2, double var3){
      try {
        gr_setwindow.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqwindow(double[] var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_inqwindow.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setviewport(double var0, double var1, double var2, double var3){
      try {
        gr_setviewport.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqviewport(double[] var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_inqviewport.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_selntran(int var0){
      try {
        gr_selntran.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setclip(int var0){
      try {
        gr_setclip.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setwswindow(double var0, double var1, double var2, double var3){
      try {
        gr_setwswindow.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setwsviewport(double var0, double var1, double var2, double var3){
      try {
        gr_setwsviewport.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_createseg(int var0){
      try {
        gr_createseg.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_copysegws(int var0){
      try {
        gr_copysegws.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_redrawsegws(){
      try {
        gr_redrawsegws.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setsegtran(int var0, double var1, double var2, double var3, double var4, double var5, double var6, double var7){
      try {
        gr_setsegtran.invoke(var0, var1, var2, var3, var4, var5, var6, var7);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_closeseg(){
      try {
        gr_closeseg.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_samplelocator(double[] var0, double[] var1, int[] var2){
      try {
        gr_samplelocator.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_INT, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_emergencyclosegks(){
      try {
        gr_emergencyclosegks.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_updategks(){
      try {
        gr_updategks.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_setspace(double var0, double var1, int var2, int var3){
      try {
        return (int)gr_setspace.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_inqspace(double[] var0, double[] var1, int[] var2, int[] var3){
      try {
        gr_inqspace.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_INT, var2), ARENA.allocateFrom(ValueLayout.JAVA_INT, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_setscale(int var0){
      try {
        return (int)gr_setscale.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_inqscale(int[] var0){
      try {
        gr_inqscale.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_textext(double var0, double var1, String var2){
      try {
        return (int)gr_textext.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_inqtextext(double var0, double var1, String var2, double[] var3, double[] var4){
      try {
        gr_inqtextext.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setscientificformat(int var0){
      try {
        gr_setscientificformat.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_axes(double var0, double var1, double var2, double var3, int var4, int var5, double var6){
      try {
        gr_axes.invoke(var0, var1, var2, var3, var4, var5, var6);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_axeslbl(double var0, double var1, double var2, double var3, int var4, int var5, double var6, String var7, String var8){
      try {
        gr_axeslbl.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_axis(char var0, GRlib_axis_t var1){
      try {
        gr_axis.invoke(var0, set_axis_t(var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawaxis(char var0, GRlib_axis_t var1){
      try {
        gr_drawaxis.invoke(var0, set_axis_t(var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawaxes(GRlib_axis_t var0, GRlib_axis_t var1, int var2){
      try {
        gr_drawaxes.invoke(set_axis_t(var0), set_axis_t(var1), var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_freeaxis(GRlib_axis_t var0){
      try {
        gr_freeaxis.invoke(set_axis_t(var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_grid(double var0, double var1, double var2, double var3, int var4, int var5){
      try {
        gr_grid.invoke(var0, var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_grid3d(double var0, double var1, double var2, double var3, double var4, double var5, int var6, int var7, int var8){
      try {
        gr_grid3d.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_verrorbars(int var0, double[] var1, double[] var2, double[] var3, double[] var4){
      try {
        gr_verrorbars.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_herrorbars(int var0, double[] var1, double[] var2, double[] var3, double[] var4){
      try {
        gr_herrorbars.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polyline3d(int var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_polyline3d.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polymarker3d(int var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_polymarker3d.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_axes3d(double var0, double var1, double var2, double var3, double var4, double var5, int var6, int var7, int var8, double var9){
      try {
        gr_axes3d.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_titles3d(String var0, String var1, String var2){
      try {
        gr_titles3d.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settitles3d(String var0, String var1, String var2){
      try {
        gr_settitles3d.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_surface(int var0, int var1, double[] var2, double[] var3, double[] var4, int var5){
      try {
        gr_surface.invoke(var0, var1, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_contour(int var0, int var1, int var2, double[] var3, double[] var4, double[] var5, double[] var6, int var7){
      try {
        gr_contour.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), var7);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_contourf(int var0, int var1, int var2, double[] var3, double[] var4, double[] var5, double[] var6, int var7){
      try {
        gr_contourf.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), var7);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_tricontour(int var0, double[] var1, double[] var2, double[] var3, int var4, double[] var5){
      try {
        gr_tricontour.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_hexbin(int var0, double[] var1, double[] var2, int var3){
      try {
        return (int)gr_hexbin.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    // public static hexbin_2pass_t* gr_hexbin_2pass(int var0, double[] var1, double[] var2, int var3, hexbin_2pass_t* var4){
    //   try {
    //     gr_hexbin_2pass.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_setcolormap(int var0){
      try {
        gr_setcolormap.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqcolormap(int[] var0){
      try {
        gr_inqcolormap.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcolormapfromrgb(int var0, double[] var1, double[] var2, double[] var3, double[] var4){
      try {
        gr_setcolormapfromrgb.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqcolormapinds(int[] var0, int[] var1){
      try {
        gr_inqcolormapinds.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0), ARENA.allocateFrom(ValueLayout.JAVA_INT, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_colorbar(){
      try {
        gr_colorbar.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqcolor(int var0, int[] var1){
      try {
        gr_inqcolor.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_INT, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_inqcolorfromrgb(double var0, double var1, double var2){
      try {
        return (int)gr_inqcolorfromrgb.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_hsvtorgb(double var0, double var1, double var2, double[] var3, double[] var4, double[] var5){
      try {
        gr_hsvtorgb.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static double gr_tick(double var0, double var1){
      try {
        return (double)gr_tick.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static int gr_validaterange(double var0, double var1){
      try {
        return (int)gr_validaterange.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_adjustlimits(double[] var0, double[] var1){
      try {
        gr_adjustlimits.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_adjustrange(double[] var0, double[] var1){
      try {
        gr_adjustrange.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_beginprint(String var0){
      try {
        gr_beginprint.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_beginprintext(String var0, String var1, String var2, String var3){
      try {
        gr_beginprintext.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_endprint(){
      try {
        gr_endprint.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_ndctowc(double[] var0, double[] var1){
      try {
        gr_ndctowc.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_wctondc(double[] var0, double[] var1){
      try {
        gr_wctondc.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_wc3towc(double[] var0, double[] var1, double[] var2){
      try {
        gr_wc3towc.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawrect(double var0, double var1, double var2, double var3){
      try {
        gr_drawrect.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_fillrect(double var0, double var1, double var2, double var3){
      try {
        gr_fillrect.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawarc(double var0, double var1, double var2, double var3, double var4, double var5){
      try {
        gr_drawarc.invoke(var0, var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_fillarc(double var0, double var1, double var2, double var3, double var4, double var5){
      try {
        gr_fillarc.invoke(var0, var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawpath(int var0, GRlib_vertex_t var1, String var2, int var3){
      try {
        gr_drawpath.invoke(var0, set_vertex_t(var1), var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setarrowstyle(int var0){
      try {
        gr_setarrowstyle.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setarrowsize(double var0){
      try {
        gr_setarrowsize.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_drawarrow(double var0, double var1, double var2, double var3){
      try {
        gr_drawarrow.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_readimage(String var0, int[] var1, int[] var2, int[] var3){
      try {
        return (int)gr_readimage.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_INT, var1), ARENA.allocateFrom(ValueLayout.JAVA_INT, var2), ARENA.allocateFrom(ValueLayout.JAVA_INT, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_drawimage(double var0, double var1, double var2, double var3, int var4, int var5, int[] var6, int var7){
      try {
        gr_drawimage.invoke(var0, var1, var2, var3, var4, var5, ARENA.allocateFrom(ValueLayout.JAVA_INT, var6), var7);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_importgraphics(String var0){
      try {
        return (int)gr_importgraphics.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_setshadow(double var0, double var1, double var2){
      try {
        gr_setshadow.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settransparency(double var0){
      try {
        gr_settransparency.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtransparency(double[] var0){
      try {
        gr_inqtransparency.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // public static void gr_setcoordxform(double[3][2] var0){
    //   try {
    //     gr_setcoordxform.invoke(var0);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_begingraphics(String var0){
      try {
        gr_begingraphics.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_endgraphics(){
      try {
        gr_endgraphics.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static String gr_getgraphics(){
      try {
        MemorySegment C_memseg = (MemorySegment)gr_getgraphics.invoke();
        return C_memseg.getString(0, StandardCharsets.UTF_8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return "";
    }

    public static int gr_drawgraphics(String var0){
      try {
        return (int)gr_drawgraphics.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static int gr_startlistener(){
      try {
        return (int)gr_startlistener.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_mathtex(double var0, double var1, String var2){
      try {
        gr_mathtex.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmathtex(double var0, double var1, String var2, double[] var3, double[] var4){
      try {
        gr_inqmathtex.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_mathtex3d(double var0, double var1, double var2, String var3, int var4){
      try {
        gr_mathtex3d.invoke(var0, var1, var2, var3, var4);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmathtex3d(double var0, double var1, double var2, String var3, int var4, double[] var5, double[] var6, double[] var7, double[] var8){
      try {
        gr_inqmathtex3d.invoke(var0, var1, var2, var3, var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_beginselection(int var0, int var1){
      try {
        gr_beginselection.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_endselection(){
      try {
        gr_endselection.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // public static void gr_setbboxcallback(int var0, void(*)(int,double,double,double,double var1){
    //   try {
    //     gr_setbboxcallback.invoke(var0, , , , , var1);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_cancelbboxcallback(){
      try {
        gr_cancelbboxcallback.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_moveselection(double var0, double var1){
      try {
        gr_moveselection.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_resizeselection(int var0, double var1, double var2){
      try {
        gr_resizeselection.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqbbox(double[] var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_inqbbox.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static double gr_precision(){
      try {
        return (double)gr_precision.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static int gr_text_maxsize(){
      try {
        return (int)gr_text_maxsize.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_setregenflags(int var0){
      try {
        gr_setregenflags.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_inqregenflags(){
      try {
        return (int)gr_inqregenflags.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_savestate(){
      try {
        gr_savestate.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_restorestate(){
      try {
        gr_restorestate.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_savecontext(int var0){
      try {
        gr_savecontext.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_selectcontext(int var0){
      try {
        gr_selectcontext.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_destroycontext(int var0){
      try {
        gr_destroycontext.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_unselectcontext(){
      try {
        gr_unselectcontext.invoke();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static int gr_uselinespec(String var0){
      try {
        return (int)gr_uselinespec.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return 0;
    }

    public static void gr_delaunay(int var0, double[] var1, double[] var2, int[] var3, int[] var4){
      try {
        gr_delaunay.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_INT, var3), ARENA.allocateFrom(ValueLayout.JAVA_INT, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_reducepoints(int var0, double[] var1, double[] var2, int var3, double[] var4, double[] var5){
      try {
        gr_reducepoints.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_trisurface(int var0, double[] var1, double[] var2, double[] var3){
      try {
        gr_trisurface.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_gradient(int var0, int var1, double[] var2, double[] var3, double[] var4, double[] var5, double[] var6){
      try {
        gr_gradient.invoke(var0, var1, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_quiver(int var0, int var1, double[] var2, double[] var3, double[] var4, double[] var5, int var6){
      try {
        gr_quiver.invoke(var0, var1, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), var6);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // interp2_method_t var10 is enum in c, java pass int
    public static void gr_interp2(int var0, int var1, double[] var2, double[] var3, double[] var4, int var5, int var6, double[] var7, double[] var8, double[] var9, int var10, double var11){
      try {
        gr_interp2.invoke(var0, var1, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), var5, var6, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var9), var10, var11);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static String gr_version(){
      try {
        MemorySegment C_memseg = (MemorySegment)gr_version.invoke();
        return C_memseg.getString(0, StandardCharsets.UTF_8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return "";
    }

    public static void gr_shade(int var0, double[] var1, double[] var2, int var3, int var4, double[] var5, int var6, int var7, int[] var8){
      try {
        gr_shade.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), var6, var7, ARENA.allocateFrom(ValueLayout.JAVA_INT, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_shadepoints(int var0, double[] var1, double[] var2, int var3, int var4, int var5){
      try {
        gr_shadepoints.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_shadelines(int var0, double[] var1, double[] var2, int var3, int var4, int var5){
      try {
        gr_shadelines.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_panzoom(double var0, double var1, double var2, double var3, double[] var4, double[] var5, double[] var6, double[] var7){
      try {
        gr_panzoom.invoke(var0, var1, var2, var3, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // public static int gr_findboundary(int var0, double[] var1, double[] var2, double var3, double(*)(double,double) var4, int var5, int var6){
    //   try {
    //     return (int)gr_findboundary.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3, , var4, var5, var6);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_setresamplemethod(int var0){
      try {
        gr_setresamplemethod.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqresamplemethod(int[] var0){
      try {
        gr_inqresamplemethod.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_path(int var0, double[] var1, double[] var2, String var3){
      try {
        gr_path.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setborderwidth(double var0){
      try {
        gr_setborderwidth.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqborderwidth(double[] var0){
      try {
        gr_inqborderwidth.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setbordercolorind(int var0){
      try {
        gr_setbordercolorind.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqbordercolorind(int[] var0){
      try {
        gr_inqbordercolorind.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_selectclipxform(int var0){
      try {
        gr_selectclipxform.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqclipxform(int[] var0){
      try {
        gr_inqclipxform.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setprojectiontype(int var0){
      try {
        gr_setprojectiontype.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqprojectiontype(int[] var0){
      try {
        gr_inqprojectiontype.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setperspectiveprojection(double var0, double var1, double var2){
      try {
        gr_setperspectiveprojection.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqperspectiveprojection(double[] var0, double[] var1, double[] var2){
      try {
        gr_inqperspectiveprojection.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settransformationparameters(double var0, double var1, double var2, double var3, double var4, double var5, double var6, double var7, double var8){
      try {
        gr_settransformationparameters.invoke(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtransformationparameters(double[] var0, double[] var1, double[] var2, double[] var3, double[] var4, double[] var5, double[] var6, double[] var7, double[] var8){
      try {
        gr_inqtransformationparameters.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setorthographicprojection(double var0, double var1, double var2, double var3, double var4, double var5){
      try {
        gr_setorthographicprojection.invoke(var0, var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqorthographicprojection(double[] var0, double[] var1, double[] var2, double[] var3, double[] var4, double[] var5){
      try {
        gr_inqorthographicprojection.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_camerainteraction(double var0, double var1, double var2, double var3){
      try {
        gr_camerainteraction.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setwindow3d(double var0, double var1, double var2, double var3, double var4, double var5){
      try {
        gr_setwindow3d.invoke(var0, var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqwindow3d(double[] var0, double[] var1, double[] var2, double[] var3, double[] var4, double[] var5){
      try {
        gr_inqwindow3d.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setscalefactors3d(double var0, double var1, double var2){
      try {
        gr_setscalefactors3d.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqscalefactors3d(double[] var0, double[] var1, double[] var2){
      try {
        gr_inqscalefactors3d.invoke(ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setspace3d(double var0, double var1, double var2, double var3){
      try {
        gr_setspace3d.invoke(var0, var1, var2, var3);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqspace3d(int[] var0, double[] var1, double[] var2, double[] var3, double[] var4){
      try {
        gr_inqspace3d.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_text3d(double var0, double var1, double var2, String var3, int var4){
      try {
        gr_text3d.invoke(var0, var1, var2, var3, var4);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtext3d(double var0, double var1, double var2, String var3, int var4, double[] var5, double[] var6){
      try {
        gr_inqtext3d.invoke(var0, var1, var2, var3, var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextencoding(int var0){
      try {
        gr_settextencoding.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqtextencoding(int[] var0){
      try {
        gr_inqtextencoding.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_loadfont(String var0, int[] var1){
      try {
        gr_loadfont.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_INT, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setcallback(String var0){
      try {
        gr_setcallback.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setthreadnumber(int var0){
      try {
        gr_setthreadnumber.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setpicturesizeforvolume(int var0, int var1){
      try {
        gr_setpicturesizeforvolume.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setvolumebordercalculation(int var0){
      try {
        gr_setvolumebordercalculation.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setapproximativecalculation(int var0){
      try {
        gr_setapproximativecalculation.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqvolumeflags(int[] var0, int[] var1, int[] var2, int[] var3, int[] var4){
      try {
        gr_inqvolumeflags.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0), ARENA.allocateFrom(ValueLayout.JAVA_INT, var1), ARENA.allocateFrom(ValueLayout.JAVA_INT, var2), ARENA.allocateFrom(ValueLayout.JAVA_INT, var3), ARENA.allocateFrom(ValueLayout.JAVA_INT, var4));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_cpubasedvolume(int var0, int var1, int var2, double[] var3, int var4, double[] var5, double[] var6, double[] var7, double[] var8){
      try {
        gr_cpubasedvolume.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // public static cpubasedvolume_2pass_t* gr_cpubasedvolume_2pass(int var0, int var1, int var2, double[] var3, int var4, double[] var5, double[] var6, double[] var7, double[] var8, cpubasedvolume_2pass_t* var9){
    //   try {
    //     gr_cpubasedvolume_2pass.invoke(var0, var1, var2, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var7), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var8), var9);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_inqvpsize(int[] var0, int[] var1, double[] var2){
      try {
        gr_inqvpsize.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0), ARENA.allocateFrom(ValueLayout.JAVA_INT, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_polygonmesh3d(int var0, double[] var1, double[] var2, double[] var3, int var4, int[] var5, int[] var6){
      try {
        gr_polygonmesh3d.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var2), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var3), var4, ARENA.allocateFrom(ValueLayout.JAVA_INT, var5), ARENA.allocateFrom(ValueLayout.JAVA_INT, var6));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }
    // // void* var2??? TODO
    // public static void gr_volume_nogrid(long var0, Glib_data_point3d_t var1, void* var2, int var3, kernel_f var4, double[] var5, double[] var6, double var7){
    //   try {
    //     gr_volume_nogrid.invoke(var0, var1, var2, var3, var4, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var5), ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var6), var7);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_volume_interp_tri_linear_init(double var0, double var1, double var2){
      try {
        gr_volume_interp_tri_linear_init.invoke(var0, var1, var2);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_volume_interp_gauss_init(double var0, double[] var1){
      try {
        gr_volume_interp_gauss_init.invoke(var0, ARENA.allocateFrom(ValueLayout.JAVA_DOUBLE, var1));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    // public static double gr_volume_interp_tri_linear(GRlib_data_point3d_t var0, void* var1, point3d_t* var2, point3d_t* var3){
    //   try {
    //     return (double)gr_volume_interp_tri_linear.invoke(var0, var1, var2, var3);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    // public static double gr_volume_interp_gauss(data_point3d_t* var0, void* var1, point3d_t* var2, point3d_t* var3){
    //   try {
    //     return (double)gr_volume_interp_gauss.invoke(var0, var1, var2, var3);
    //   } catch (Throwable e) {
    //     e.printStackTrace();
    //   }
    // }

    public static void gr_setmathfont(int var0){
      try {
        gr_setmathfont.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqmathfont(int[] var0){
      try {
        gr_inqmathfont.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_setclipregion(int var0){
      try {
        gr_setclipregion.invoke(var0);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_inqclipregion(int[] var0){
      try {
        gr_inqclipregion.invoke(ARENA.allocateFrom(ValueLayout.JAVA_INT, var0));
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static void gr_settextoffset(double var0, double var1){
      try {
        gr_settextoffset.invoke(var0, var1);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    public static String gr_ftoa(String var0, double var1, GRlib_format_reference_t var2){
      try {
        MemorySegment C_memseg = (MemorySegment)gr_ftoa.invoke(var0, set_format_reference_t(var2), var2);
        return C_memseg.getString(0, StandardCharsets.UTF_8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
      return "";
    }

    public static void gr_getformat(GRlib_format_reference_t var0, double var1, double var2, double var3, double var4, int var5){
      try {
        gr_getformat.invoke(set_format_reference_t(var0), var1, var2, var3, var4, var5);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }
}
