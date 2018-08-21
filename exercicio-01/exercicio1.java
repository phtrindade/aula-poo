public static void main(String[] args) {
        for(int i = 1; i<100; i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

public static void main(int args) {
        switch (args) {
            case 1:
                System.out.println("domingo");
                break;
            case 2:
                System.out.println("segunda-feira");
                break;
            case 3:
                System.out.println("terça-feira");
                break;
            case 4:
                System.out.println("quarta-feira");
                break;
            case 5:
                System.out.println("quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("erro");
                break;
        }
    }