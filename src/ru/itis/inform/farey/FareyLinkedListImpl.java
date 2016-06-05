package ru.itis.inform.farey;

import ru.itis.inform.lists.*;

public class FareyLinkedListImpl {
    LinkedList<RationalNum> list;

    public void runFarey(int n) {
        LinkedList<RationalNum> list = new LinkedList<>();

        RationalNum first = new RationalNum(0, 1);
        RationalNum last = new RationalNum(1, 1);
        list.add(last);
        list.add(first);
        int i = 2;
        while (i <= n) {

            Iterator<RationalNum> iterator = list.iterator();
            iterator.next();
            while (iterator.hasNext()) {

                int b = iterator.peekPrevious().getDenominator() + iterator.peekNext().getDenominator();
                if (b == i) {

                    RationalNum newOne = new RationalNum(iterator.peekPrevious().getNumerator() + iterator.peekNext().getNumerator(), b);
                    iterator.insert(newOne);

                }

                iterator.next();

            }

            i++;
        }
        this.list=list;
    }

        public void show() {
            Iterator<RationalNum> result = list.iterator();
            while(result.hasNext()) {
                RationalNum resrat = result.next();
                int a = resrat.getNumerator();
                int b = resrat.getDenominator();
                System.out.print(a + "/" + b + ", ");
            }
            System.out.println();
        }
    }


