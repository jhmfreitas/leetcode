package blind75.easy;

class FloodFill {
    int color;
    int startPixelColor;
    int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (sc<0 || sr < 0 || sr >= image.length || sc >= image[0].length)
            return image;

        this.color = color;
        this.image = image;
        this.startPixelColor = this.image[sr][sc];
        dfsFill(sr, sc);
        return this.image;
    }

    private void dfsFill(int sr, int sc) {
        if (sc<0 || sr < 0 || sr == this.image.length || sc == this.image[0].length || this.image[sr][sc] != this.startPixelColor || this.image[sr][sc] == this.color)
            return;

        this.image[sr][sc] = this.color;

        dfsFill(sr - 1 ,sc);
        dfsFill(sr,sc-1);
        dfsFill(sr + 1 ,sc);
        dfsFill(sr,sc+1);
    }
}
