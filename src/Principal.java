
import com.specification.Shipment;
import static com.specification.predicate.ShipmentRules.minimumWeight;
import static com.specification.predicate.ShipmentRules.packageMustHaveAtLeastItems;
import static com.specification.predicate.ShipmentRules.requestWithinTheTimeLimit;
import com.specification.predicate.Specification;
import com.specification.validation.MinimumWeight;
import com.specification.validation.PackageMustHaveAtLeastItems;
import com.specification.validation.RequestWithinTheTimeLimit;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Principal {

    private static final String SUCCESS_MESSAGE = "O envio foi executado com sucesso";
    private static final String ERROR_MESSAGE = "O envio falhou";

    public static void main(String[] args) {

        LocalDateTime requestDate = LocalDateTime.now().minus(5, ChronoUnit.DAYS);
        Shipment shipment = Shipment.newInstance(requestDate, 50000L, 10D);

        // Estrutura tradicional
        Boolean resultTradSpec = new MinimumWeight().
                and(new PackageMustHaveAtLeastItems(25L)).
                and(new RequestWithinTheTimeLimit()).isSatisfiedBy(shipment);
        System.out.println(resultTradSpec ? SUCCESS_MESSAGE : ERROR_MESSAGE);

        // Especificação usando predicado abstraído em uma classe
        Boolean resultLambdaSpec = new Specification<Shipment>()
                .and(minimumWeight())
                .and(packageMustHaveAtLeastItems(25L))
                .and(requestWithinTheTimeLimit())
                .isSatisfiedBy(shipment);
        System.out.println(resultLambdaSpec ? SUCCESS_MESSAGE : ERROR_MESSAGE);

        // Usando apenas a Interface Funcional de Predicado
        Boolean resultPredicate = minimumWeight()
                .and(packageMustHaveAtLeastItems(1000000L))
                .and(requestWithinTheTimeLimit())
                .test(shipment);
        System.out.println(resultPredicate ? SUCCESS_MESSAGE : ERROR_MESSAGE);

    }
}
