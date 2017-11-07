package aggregator.model;


import aggregator.view.View;
import aggregator.vo.Vacancy;

import java.util.ArrayList;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        this.view = view;
        this.providers = providers;

        if(providers == null || providers.length == 0 || view == null){
            throw new IllegalArgumentException();
        }
    }

    public void selectCity(String city){
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        for(Provider provider: providers){
            vacancies.addAll(provider.getJavaVacancies(city));
        }

        view.update(vacancies);
    }
}
