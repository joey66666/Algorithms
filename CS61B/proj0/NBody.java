public class NBody {
    public static double readRadius(String url) {
        In in = new In(url);
        int number = in.readInt();
        double radius = in.readDouble();
        String s1 = in.readString();
        return radius;
    }

    public static Body[] readBodies(String url) {
        In in = new In(url);
        int number = in.readInt();
        Body[] body = new Body[number];
        double radius = in.readDouble();

        for (int i = 0; i < number; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgName = in.readString();
            body[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgName);
        }
        return body;
    }


    public static void main(String[] args) {
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        int num = bodies.length;


        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body b : bodies) {
            b.draw();
        }

        StdDraw.enableDoubleBuffering();
        for (int time = 0; time < T; time += dt) {
            Double[] xForces = new Double[num];
            Double[] yForces = new Double[num];

            int i = 0;
            for (Body b : bodies) {
                Double netxForce = b.calcNetForceExertedByX(bodies);
                Double netyForce = b.calcNetForceExertedByY(bodies);
                xForces[i] = netxForce;
                yForces[i] = netyForce;
                i += 1;
            }

            i = 0;
            for (Body b : bodies) {
                b.update(dt, xForces[i], yForces[i]);
                i += 1;
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b : bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
