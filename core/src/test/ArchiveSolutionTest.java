package test;

import com.galliblock.model.ArchiveSolutions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArchiveSolutionTest {

    private ArchiveSolutions archive;

    @Before
    public void loadMap() {
        archive = new ArchiveSolutions();
    }

    @Test
    public void esd_le_02() {
        assertEquals("2.52 E 05\n", archive.solve(102, 500).toString());
    }

    @Test
    public void esk_pm_02() {
        assertEquals("1.67 E 01\n4.71 E 01\n", archive.solve(802, 500).toString());
    }

    @Test
    public void esk_pm_03() {
        assertEquals("1.67 E 01\n4.71 E 01\n", archive.solve(803, 500).toString());
    }

    @Test
    public void esk_pm_08() {
        assertEquals("1.13 E 06\n", archive.solve(808, 500).toString());
    }

    @Test
    public void esk_pm_17() {
        assertEquals("6.67 E 05\n", archive.solve(817, 500).toString());
    }

    @Test
    public void esd_pm_02() {
        assertEquals("-1.89 E 07\n9.80 E 05\n", archive.solve(302, 500).toString());
    }

    @Test
    public void esd_pm_03() {
        assertEquals("5.46 E -01\n2.74 E 00\n", archive.solve(303, 500).toString());
    }

    @Test
    public void esd_pm_05() {
        assertEquals("1.13 E -01\n1.89 E 00\n", archive.solve(305, 500).toString());
    }

    @Test
    public void esd_pm_10() {
        assertEquals("1.78 E 01\n9.00 E 00\n", archive.solve(310, 500).toString());
    }

    @Test
    public void esd_pm_14() {
        assertEquals("7.55 E 01\n", archive.solve(314, 500).toString());
    }

    @Test
    public void esd_pm_18() {
        assertEquals("2.91 E 00\n", archive.solve(318, 500).toString());
    }

    @Test
    public void esd_pm_20() {
        assertEquals("4.95 E 00\n", archive.solve(320, 500).toString());
    }

    @Test
    public void esd_pm_21() {
        assertEquals("3.19 E 01\n0.00 E 00\n", archive.solve(321, 500).toString());
    }

    @Test
    public void esd_pm_22() {
        assertEquals("3.12 E 01\n3.48 E 01\n", archive.solve(322, 500).toString());
    }

    @Test
    public void esd_si_01() {
        assertEquals("8.79 E 22\n1.17 E 22\n", archive.solve(201, 500).toString());
    }

    @Test
    public void esd_si_02() {
        assertEquals("1.99 E 00\n", archive.solve(202, 500).toString());
    }

    @Test
    public void esd_mi_01() {
        assertEquals("3.59 E 00\n", archive.solve(601, 500).toString());
    }

    @Test
    public void esd_mi_02() {
        assertEquals("3.38 E 01\n", archive.solve(602, 500).toString());
    }

    @Test
    public void esd_mi_08() {
        assertEquals("1.97 E 14\n", archive.solve(608, 500).toString());
    }

    @Test
    public void esd_cr_02() {
//        assertEquals("3.33 E 01\n7.08 E 00", archive.solve(502, 500).toString());
    }

    @Test
    public void esd_cr_04() {
        assertEquals("8.72 E -01\n", archive.solve(504, 500).toString());
    }

    @Test
    public void esd_cr_12() {
        assertEquals("8.21 E -01\n4.08 E -01\n", archive.solve(512, 500).toString());
    }

    @Test
    public void esd_cr_13() {
        assertEquals("5.00 E 01\n", archive.solve(513, 500).toString());
    }

    @Test
    public void esd_cr_18() {
        assertEquals("1.12 E 00\n", archive.solve(518, 500).toString());
    }

    @Test
    public void esd_cr_19() {
        assertEquals("6.54 E -01\n", archive.solve(519, 500).toString());
    }

    @Test
    public void esd_cr_21() {
        assertEquals("1.47 E 00\n", archive.solve(521, 500).toString());
    }

    @Test
    public void esd_cr_22() {
        assertEquals("8.19 E -01\n", archive.solve(522, 500).toString());
    }

    @Test
    public void esd_ur_01() {
        assertEquals("7.69 E 00\n6.15 E 01\n9.23 E 00\n", archive.solve(401, 500).toString());
    }

    @Test
    public void esd_ur_02() {
        assertEquals("4.00 E 01\n4.62 E 00\n", archive.solve(402, 500).toString());
    }

    @Test
    public void esd_ur_03() {
        assertEquals("5.48 E 00\n3.10 E 01\n", archive.solve(403, 500).toString());
    }

    @Test
    public void esd_ur_04() {
        assertEquals("1.55 E 01\n", archive.solve(404, 500).toString());
    }

    @Test
    public void esd_ur_05() {
        assertEquals("0.00 E 00\n2.00 E 01\n", archive.solve(405, 500).toString());
    }

    @Test
    public void esd_ur_06() {
        assertEquals("3.33 E 00\n", archive.solve(406, 500).toString());
    }

    @Test
    public void esd_ur_07() {
        assertEquals("3.00 E 01\n9.66 E 01\n", archive.solve(407, 500).toString());
    }

    @Test
    public void esd_ur_08() {
        assertEquals("8.40 E 01\n9.05 E 00\n", archive.solve(408, 500).toString());
    }

    @Test
    public void esd_ur_09() {
        assertEquals("-5.72 E 01\n3.33 E 01\n", archive.solve(409, 500).toString());
    }

    @Test
    public void ess_ec_06() {
        assertEquals("4.91 E 00\n4.91 E -03\n8.50 E 00\n", archive.solve(706, 500).toString());
    }
}
