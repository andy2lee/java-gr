package GRlibPackage;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemoryLayout;
import static GRlibPackage.GRlib.*;
import static java.lang.foreign.ValueLayout.*;

public class GRlib_tick_label_t {
    public double tick;
    public String label;
    public double width;
    public MemorySegment na_memseg;

    public GRlib_tick_label_t(
        double tick, 
        String label, 
        double width
    ) {
        this.tick = tick;
        this.label = label;
        this.width = width;

        memseg_set();
    }

    void memseg_set() {
        MemorySegment na_memseg = ARENA.allocate(ticks_label_t_Layout);
        // na_memseg.set(JAVA_DOUBLE, 0, tick);
        // na_memseg.set(ADDRESS, 8, ARENA.allocateFrom(label));
        // na_memseg.set(JAVA_DOUBLE, 16, width);

        ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("tick")).set(na_memseg, 0, tick);
        ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("label")).set(na_memseg, 0, ARENA.allocateFrom(label));
        ticks_label_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("width")).set(na_memseg, 0, width);

        this.na_memseg = na_memseg;
    }
}