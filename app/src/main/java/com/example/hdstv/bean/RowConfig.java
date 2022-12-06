package com.example.hdstv.bean;

public class RowConfig {

    public final RowMargin margin;
    public final int numCols;
    //整行的水平padding
    public final int paddingHorizon;

    public RowConfig(RowMargin margin, int numCols, int paddingHorizon){
        this.margin = margin;
        this.numCols = numCols;
        this.paddingHorizon = paddingHorizon;
    }

    @Override
    public String toString() {
        return "RowConfig{" +
                "margin=" + margin +
                ", numCols=" + numCols +
                ", paddingHorizon=" + paddingHorizon +
                '}';
    }

    public static final class RowMargin{

        public final int marginHorizontal;
        public final int marginVertical;
        public RowMargin(int marginHorizontal, int marginVertical){
            this.marginHorizontal = marginHorizontal;
            this.marginVertical = marginVertical;
        }

        @Override
        public String toString() {
            return "RowMargin{" +
                    "marginHorizontal=" + marginHorizontal +
                    ", marginVertical=" + marginVertical +
                    '}';
        }
    }
}
