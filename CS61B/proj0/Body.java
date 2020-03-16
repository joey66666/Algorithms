public class Body {
    /*
    double xxPos: Its current x position
    double yyPos: Its current y position
    double xxVel: Its current velocity in the x direction
    double yyVel: Its current velocity in the y direction
    double mass: Its mass
    String imgFileName: The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)
    */

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        /*
        AB两点的距离
        r = sqrt(abs(x1-x2)^2 + abs(y1-y2)^2)
        不用abs
        */
        double xDis = 0;
        double yDis = 0;
        if (b.xxPos >= this.xxPos) {
            xDis = b.xxPos - this.xxPos;
        } else if (b.xxPos < this.xxPos) {
            xDis = this.xxPos - b.xxPos;
        }

        if (b.yyPos >= this.yyPos) {
            yDis = b.yyPos - this.yyPos;
        } else if (b.yyPos < this.yyPos) {
            yDis = this.yyPos - b.yyPos;
        }

        double distance = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
        return distance;
    }

    public double calcForceExertedBy(Body b) {
        /*
        AB两点间力
        F = (G * m1 * m2) / r^2
        */
        double G = 6.67e-11;
        double r = calcDistance(b);
        double F = (this.mass * b.mass * G) / Math.pow(r, 2);
        return F;
    }

    public double calcForceExertedByX(Body b) {
        /*
         * 力在x上的方向
         * Fx = (F * dx) / r
         * */
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        double dx = b.xxPos - this.xxPos;
        double Fx = (F * dx) / r;
        return Fx;
    }

    public double calcForceExertedByY(Body b) {
        /*
         * 力在y上的方向
         * Fy = (F * dy) /r
         * */
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        double dy = b.yyPos - this.yyPos;
        double Fy = (F * dy) / r;
        return Fy;
    }

    public double calcNetForceExertedByX(Body[] allBodys) {
        /*
        * 某点收到一个list里全部点的力
        * Body[] allBodys = {samh, rocinante, aegir};
            samh.calcNetForceExertedByX(allBodys);
            samh.calcNetForceExertedByY(allBodys);
            排除自己
        * */
        double Fx = 0;
        for (int i = 0; i < allBodys.length; i += 1) {
            if (allBodys[i].equals(this)) {
                continue;
            }
            double F = this.calcForceExertedBy(allBodys[i]);
            double r = this.calcDistance(allBodys[i]);
            double dx = allBodys[i].xxPos - this.xxPos;
            Fx += (F * dx) / r;
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Body[] allBodys) {
        double Fy = 0;
        for (int i = 0; i < allBodys.length; i += 1) {
            if (allBodys[i].equals(this)) {
                continue;
            }
            double F = this.calcForceExertedBy(allBodys[i]);
            double r = this.calcDistance(allBodys[i]);
            double dy = allBodys[i].yyPos - this.yyPos;
            Fy += (F * dy) / r;
        }
        return Fy;
    }

    public void update(double dt, double fX, double fY) {
        /*
         * 根据加速度更新坐标
         * a = F / m
         * Vnew = Vold + a * dt
         * Pnew = Pold + Vnew * dt
         * */
        double m = this.mass;
        double voldx = this.xxVel;
        double voldy = this.yyVel;
        double poldx = this.xxPos;
        double poldy = this.yyPos;

        double anetx = fX / m;
        double anety = fY / m;

        double vnewx = voldx + dt * anetx;
        double vnewy = voldy + dt * anety;

        this.xxVel = vnewx;
        this.yyVel = vnewy;

        double pnewx = poldx + dt * vnewx;
        double pnewy = poldy + dt * vnewy;

        this.xxPos = pnewx;
        this.yyPos = pnewy;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
//        StdDraw.show();
    }

}
