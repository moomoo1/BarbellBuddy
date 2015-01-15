package moomoo_1.free_weightbuddy;

/**
 * Created by Muzammil on 1/14/2015.
 */
public class weightCalc {

    int[] impWeights = new int[5];
    int[] metWeights = new int[5];
    double[] weightSetsImp = {45, 25, 10, 5, 2.5};
    double[] weightSetsMet = {20.4, 11.3, 4.5, 2.3, 1.13};
    double mWeight;

    public int[] getImpWeights() {
        return impWeights;
    }

    public void setImpWeights(double weight) {
        mWeight = (weight - 45) / 2;
        for (int i = 0; i < impWeights.length; i++) {
            impWeights[i] = (int) (mWeight / weightSetsImp[i]);
            mWeight = mWeight % weightSetsImp[i];
        }
    }

    public int[] getMetWeights() {
        return metWeights;
    }

    public void setMetWeights(double weight) {
        mWeight = (weight - 20.4) / 2;
        for (int i = 0; i < metWeights.length; i++) {
            metWeights[i] = (int) (mWeight / weightSetsMet[i]);
            mWeight = weight % weightSetsMet[i];
        }
    }
}
