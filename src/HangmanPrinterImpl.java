public class HangmanPrinterImpl implements HangmanPrinter {

    private final int ROW_COUNT = 7;
    private final int COLUMN_COUNT = 11;
    private final String EMPTY_SLOT = " ";
    private String[][] picture;

    public HangmanPrinterImpl() {
        this.picture = new String[ROW_COUNT][COLUMN_COUNT];
    }

    @Override
    public void printPicture() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COLUMN_COUNT; col++) {
                System.out.print(picture[row][col]);
            }
            System.out.println();
        }
    }

    @Override
    public void setBeginPicture() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COLUMN_COUNT; col++) {
                picture[row][col] = EMPTY_SLOT;
            }
        }
        for (int col = 2; col < 8; col++) {
            picture[0][col] = "_";
        }

        for (int row = 1; row < ROW_COUNT; row++) {
            picture[row][2] = "|";
        }
        picture[1][8] = "|";
    }

    @Override
    public void addHead() {
        picture[2][8] = "O";
    }

    @Override
    public void addLeftHand() {
        picture[3][7] = "/";
    }

    @Override
    public void addRightHand() {
        picture[3][9] = "\\";
    }

    @Override
    public void addBody() {
        picture[3][8] = "|";
    }

    @Override
    public void addLeftLeg() {
        picture[4][7] = "/";
        picture[4][6] = "_";
    }

    @Override
    public void addRightLeg() {
        picture[4][9] = "\\";
        picture[4][10] = "_";
    }

    @Override
    public void addMistakePicture(int mistakeNumber) {
        switch (mistakeNumber) {
            case 1:
                addHead();
                break;
            case 2:
                addBody();
                break;
            case 3:
                addLeftHand();
                break;
            case 4:
                addRightHand();
                break;
            case 5:
                addRightLeg();
                break;
            case 6:
                addLeftLeg();
        }
    }


}
