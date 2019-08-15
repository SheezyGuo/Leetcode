public class 矩形面积 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A, E);
        int y1 = Math.min(D, H);
        int x2 = Math.min(C, G);
        int y2 = Math.max(B, F);
        return (E > C || H < B || A > G || D < F ? 0 : -(y1 - y2) * (x2 - x1)) + (D - B) * (C - A) + (H - F) * (G - E);
    }
}
