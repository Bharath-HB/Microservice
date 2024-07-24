package com.ust.Recommend_Service.Repository;

import com.ust.Recommend_Service.Model.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommend,String> {

}
