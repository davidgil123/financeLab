package co.com.financelab.model.income.gateways;

import co.com.financelab.model.income.Income;
import co.com.financelab.model.user.User;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IncomeRepository {
    Mono<List<Income>> getAllIncome(String userId);
    Mono<Income> createIncome(Income income); //Aqui necesitamos que desde el front se manden todos los campos para la creación del income
    Mono<Income> updateIncome(Income income);//Aqui necesitamos que desde el front se manden todos los campos del income con el dato qie quiera actualizar.
    Mono<Boolean> deleteIncome(String userId, String incomeId);//Aqui necesitamos que desde el front se el income que se quiere eliminar.
}
