//Student Name: Yasmin Woodlock
//ID Number: 22336877
public class Image {
    private int[][] pixels;
    private int width;
    private int height;

    public Image(int[][] pixels) {
        this.pixels = pixels;
        this.height = pixels.length;
        this.width = pixels[0].length;
    }

    public String toString(){
        //checking if class is given an empty array, so it doesn't return "\n"
        if (pixels[0].length < 1){
            return "";
        }
        else{
            //Using StringBuilder for performance reasons
            StringBuilder gridString = new StringBuilder();
            for (int rows = 0; rows < height; rows++){
                for (int value : pixels[rows]){
                    //formatted to 3 characters, meaning while it can accommodate more characters, it would throw off the grid.
                    //I could increase this, but for this assignment I found this suitable.
                    gridString.append(String.format("%3d ", value));
                }
                gridString.append("\n");
            }
            return gridString.toString();
        }
    }

    public void flip(boolean horizontal){
        //flipping horizontally
        if(horizontal){
            //iterating through each row in the grid
            for(int rows = 0; rows < height; rows++) {
                //reversing values in an array - segment gotten from geeks for geeks
                int[] tempRow = new int[width];
                //using another variable because I will be decreasing this value
                int tempWidth = width;
                //assigning the last index in tempRow as the first index in pixels and so on
                for (int values = 0; values < width; values++) {
                    tempRow[tempWidth - 1] = pixels[rows][values];
                    tempWidth -= 1;
                }
                //replacing current pixels row with the reversed row
                pixels[rows] = tempRow;
            }
        }
        //flipping vertically, applying same logic as above but on the outer array instead
        else{
            int[][] tempGrid = new int[height][width];
            int tempHeight = height;
            for (int rows = 0; rows  < height; rows++){
                tempGrid[tempHeight - 1] = pixels[rows];
                tempHeight -= 1;
            }
            //reassigning pixels to the new, flipped grid
            pixels = tempGrid;
        }
    }

    public void rotate(boolean clockwise){
        //making a new 2d array with opposite dimensions.
        int[][] newPixels = new int[width][height];
        //changing the rows to be the columns and vice versa
        for (int i = 0; i < height; i++){
            for(int x = 0; x < width; x++){
                newPixels[x][i] = pixels[i][x];
            }
        }

        //resetting values to new ones
        pixels = newPixels;
        height = pixels.length;
        width = pixels[0].length;

        //flipping either vertically or horizontally, based on what direction you want to rotate.
        //this flip rotates the image.
        flip(clockwise);
    }
}