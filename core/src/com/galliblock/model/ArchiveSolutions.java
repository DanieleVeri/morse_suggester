package com.galliblock.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

public class ArchiveSolutions {

    private Map<Integer, Exercise> map;

    private static final double pi = PI;
    private static final double g = 9.81;
    private static final double G = 6.674e-11;
    private static final double pc = 3.0856e16;

    public ArchiveSolutions() {
        map = new HashMap<Integer, Exercise>();
        loadExercise();
    }

    public ResultCollection solve(List<Integer> args) {
        int numEs = args.get(0)*100 + args.get(1)*10 + args.get(2);
        int epsilon = args.get(3)*100 + args.get(4)*10 + args.get(5);
        return solve(numEs,epsilon);
    }

    public ResultCollection solve(int numEs, int epsilon) {
        if (map.get(numEs) == null) {
            throw new IllegalArgumentException("Illegal exercise: " + numEs);
        }

        List<Result> list = new ArrayList<Result>();
        double results[] = map.get(numEs).calc(epsilon);

        for (double d : results) {
            list.add(new Result(d));
        }

        return new ResultCollection(list);
    }

    // Exercises:

    interface Exercise {
        double[] calc(double x);
    }

    private void loadExercise() {

        // d_le_02
        map.put(102, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                x*x+4*x
        };}});

        // k_pm_02
        map.put(802, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                100.0/6.0/tan(pi*x/2000),
                100.0/3.0/sin(x*pi/2000)
        };}});

        // k_pm_03
        map.put(803, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                100.0/6.0*tan(pi*x/2000),
                100.0/3.0/cos(x*pi/2000)
        };}});

        // k_pm_08
        map.put(808, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                pow(x*x*9+1, 1.5)/6/x
        };}});

        // k_pm_17
        map.put(817, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                (144+16*x*x)/ sqrt(144+4*x*x- pow((144+8*x*x)/ sqrt(144+16*x*x),2))
        };}});

        // d_pm_02
        map.put(302, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                -50.0* pow(2*pi*G* pow(10,24)/(x*3600), 2.0/3.0),
                pow(2.0/3.0, 3.0/2.0)*x*3600
        };}});

        // d_pm_03
        map.put(303, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                x<1000.0/ sqrt(3)? sqrt((1-x* sqrt(3)/1000.0)/(sqrt(3)+x/1000.0))* sqrt(g/0.05)/2/pi:0,
                sqrt((1+x* sqrt(3)/1000.0)/(sqrt(3)-x/1000.0))* sqrt(g/0.05)/2/pi
        };}});

        // d_pm_05
        map.put(305, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                8.0/ sqrt(10*x),
                8.0/30.0/ sqrt(10)* sqrt(x)
        };}});

        // d_pm_10
        map.put(310, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                sqrt(g* pow(1+x/100.0,2.0)-pi*g/5.0*(1+x/100.0)),
                (int)(pow(1+x/100.0, 2)*5/pi/(1+x/100.0))
        };}});

        // d_pm_14
        map.put(314, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                toDegrees(acos(0.5-x/2000.0))
        };}});

        // d_pm_18
        map.put(318, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                sqrt((100*g+g*x)/(800* sqrt(0.75)))
        };}});

        // d_pm_20
        map.put(320, new Exercise() { @Override public double[] calc(double x) { return new double[]{
                sqrt(6*(2+x/200)/5.0/(3+x/200.0))/200.0*(500+x)
        };}});

        // d_pm_21
        map.put(321, new Exercise() { @Override public double[] calc(double x) {
            double v0 = 1.5+x/500;
            return new double[]{
                v0<2* sqrt(g*0.2)?v0*v0/2/g*100:40,
                v0<2* sqrt(g*0.2)?0: sqrt(v0*v0-4*g*0.2)*100
        };}});

        // d_pm_22
        map.put(322, new Exercise() { @Override public double[] calc(double x) {
            double v0 = 1.5+x/500;
            return new double[]{
                    v0< sqrt(g*0.4)?v0*v0/2/g*100:v0< sqrt(g)?(v0*v0/2/g- pow((v0*v0-0.4*g)/3,3)/2/g/g/g/0.04)*100:40,
                    v0< sqrt(g*0.4)?0:v0< sqrt(g)?(pow((v0*v0-0.4*g)/3.0,1.5)/g/0.2)*100: sqrt(v0*v0-g*0.8)*100
            };}});

        // d_si_01
        map.put(201, new Exercise() { @Override public double[] calc(double x) { double d = 8e+11;return new double[]{
                (pow(8e+7+6e+8,2)*4*pi*pi*8e+7/G/ pow(x*3600*24,2))*60.0/8.0,
                pow(8e+7+6e+8,2)*4*pi*pi*8e+7/G/ pow(x*3600*24,2)
        };}});

        // d_si_02
        map.put(202, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                pow(800+3*x,2)*3*1e4*pc/4/G/pi/1e-22/ pow(1000*pc,3)
        };}});

        // d_mi_01
        map.put(601, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                pow(0.78+x/200,2)/3
        };}});

        // d_mi_02
        map.put(602, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                (pow(x/100,4)- pow(x/300,4))*pi*pi/180
        };}});

        // d_mi_08
        map.put(608, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                2*pi*(pow(x,4)+pow(x,5))
        };}});

        // d_cr_02 !
        map.put(502, new Exercise() { @Override public double[] calc(double x) { double v=(0.3*0.03*0.03*x)/(1000*0.3*0.03*0.03*(0.4+0.0002*x)); return new double[] {
                (x/1000-v)/g/0.1*100,
                (pow(x/1000,2)-pow(v,2)/0.2/g)*100
        };}});

        // d_cr_04
        map.put(504, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                g*sin(toRadians(8*x/100.0))/(7+2*pow(sin(toRadians(4*x/100.0)),2))
        };}});

        // d_cr_12
        map.put(512, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                g*(0.1-0.1*sin(toRadians(9*x/100)))/0.35,
                0.05*0.1*g*(0.75+sin(toRadians(9*x/100)))/0.175
        };}});

        // d_cr_13
        map.put(513, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                (0.75-x/2000)*100
        };}});

        // d_cr_18
        map.put(518, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                1.5-3*x/4000
        };}});

        // d_cr_19
        map.put(519, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                g/(5+x/50)
        };}});

        // d_cr_21
        map.put(521, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                5*(1+x/100)*g/200
        };}});

        // d_cr_22
        map.put(522, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                2*pi*sqrt((0.05+x/1e4)/(0.6*g))
        };}});

        // d_ur_01
        map.put(401, new Exercise() { @Override public double[] calc(double x) {
            double m = 0.1, M = m*(1+x/1000), l = 0.1, I = M*l*l/3, d = l*x/1000.0,
                    v=(m/M + m/I*pow(l-d,2) - 1)/(m/M + m/I*pow(l-d,2) + 1);
            return new double[] {
                    v*100,
                    m/M*(1-v)*100,
                    m*(l-d)/I*(1-v)
        };}});

        // d_ur_02
        map.put(402, new Exercise() { @Override public double[] calc(double x) {
            double m = 0.1, M = m*(1+x/1000), l = 0.1, d = l*x/1000.0, I = M*l*l/3 + m*M*pow(l-d,2)/(m+M);
            return new double[] {
                    m/(m+M)*100,
                    M/(M+m)*(l-d)*m/I
            };}});

        // d_ur_03
        map.put(403, new Exercise() { @Override public double[] calc(double x) {
            double m = 2, b = 1-x/1000, v=10, I = (1.0/3.0+pow(x/2000,2)-x/2000);
            return new double[] {
                    (1-I/m/b/b)/(1+I/m/b/b)*v,
                    2*v/b/(1+I/m/b/b)
            };}});

        // d_ur_04
        map.put(404, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                20*(1-x/1000)/(1.0/12.0+pow(0.5-x/2000, 2)+2*pow(1-x/1000,2))
            };}});

        // d_ur_05
        map.put(405, new Exercise() { @Override public double[] calc(double x) { double I = .5+pow(x/1000,2); return new double[] {
                (1-I/3.0/pow(x/1000,2))/(1+I/3.0/pow(x/1000,2))*10,
                20/x*1000/(1+I/3.0/pow(x/1000,2))
        };}});

        // d_ur_06
        map.put(406, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                30*(x/1000)/(3.5+4*pow(x/1000,2))
        };}});

        // d_ur_07
        map.put(407, new Exercise() { @Override public double[] calc(double x) {
            double p=7*x/1e5/0.07, n=0.5*p*sqrt(1-p*p), d=0.5*p*p-.15;
            return new double[] {
                toDegrees(asin(p)),
                d>0?toDegrees(atan(n/d)):d<0?toDegrees(atan(n/d)+pi):n>0?toDegrees(.5*pi):0
        };}});

        // d_ur_08
        map.put(408, new Exercise() { @Override public double[] calc(double x) {
            int N = (int) (x/6*sqrt(10/g));
            return new double[] {
                    N,
                    N%2==0?
                            (x/10*sqrt(10/g)-0.6*N)*100 :
                            (0.6-x/10*sqrt(10/g)+0.6*N)*100
            };}});

        // d_ur_09
        map.put(409, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                (-100/x*sqrt(g/(1+100/x)))*100,
                .8*.5*(1-1/(1+x/100))*100
        };}});

        // s_ec_06
        map.put(706, new Exercise() { @Override public double[] calc(double x) { return new double[] {
                x/1000.0*g,
                (x/1000*g-3e-6*x*x*g*sin(pi/6))/x/x*1000,
                x/1000*g*sqrt(2+2*sin(pi/6))
        };}});
    }
}
