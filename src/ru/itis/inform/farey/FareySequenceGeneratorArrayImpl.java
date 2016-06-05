package ru.itis.inform.farey;

public class FareySequenceGeneratorArrayImpl {
    private final int MAX_FAR_LENGHT = 100;
    private RationalNum[] mas;
    private int lenght;
    FareySequenceGeneratorArrayImpl(){
        this.mas = new RationalNum[MAX_FAR_LENGHT];
        this.mas[0] = new RationalNum(0, 1);
        this.mas[1] = new RationalNum(1, 1);
        this.lenght=2;
    }
    public void generate(int n){
        for(int i=2; i<=n; i++){
            for(int j=0; j<=lenght-2; j++){
                if(mas[j].getDenominator() + mas[j+1].getDenominator() <=  i){
                    lenght++;
                    System.arraycopy(mas, j + 1, mas, j + 1 + 1, lenght - 1 - (j + 1));
                    RationalNum m = new RationalNum(mas[j].getNumerator() + mas[j+1].getNumerator(), mas[j].getDenominator() + mas[j+1].getDenominator());
                    mas[j+1] = m;
                    j++;
                }
            }
        }
    }
    public void print(){
        for(int i=0; i<lenght-1; i++){
            System.out.print(mas[i].getNumerator() + "/" + mas[i].getDenominator() +", ");
        }
        System.out.print(mas[lenght-1].getNumerator() + "/" + mas[lenght-1].getDenominator());
    }
}
