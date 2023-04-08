//package org.example.repositories;
//
//import org.example.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//@EnableJpaRepositories
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUserLogin(String personLogin);
//
//    Optional<User> findById(Long userId);
//
//    void deleteById(Long userId);
//
//    List<User> findAll();
//
//}
