package GRlibPackage;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemoryLayout;
import static GRlibPackage.GRlib.*;
import static java.lang.foreign.ValueLayout.*;

public class GRlib_tick_t {
    public double value;
    public int is_major;
    public MemorySegment na_memseg;

    public GRlib_tick_t(
        double value,
        int is_major
    ) {
        this.value = value;
        this.is_major = is_major;

        memseg_set();
    }

    void memseg_set() {
        MemorySegment na_memseg = ARENA.allocate(ticks_t_Layout);
        // na_memseg.set(JAVA_DOUBLE, 0, value);
        // na_memseg.set(JAVA_INT, 8, is_major);

        ticks_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("value")).set(na_memseg, 0, value);
        ticks_t_Layout.varHandle(MemoryLayout.PathElement.groupElement("is_major")).set(na_memseg, 0, is_major);

        this.na_memseg = na_memseg;
    }
}
