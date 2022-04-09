package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.DTO.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(nativeQuery = true, value = "select movies.id, movies.name from movies "
			+ "inner join genres on movies.id_genres = genres.id "
			+ "where genres.description = :genreName" )
	List <MovieMinProjection> search1(String genreName);
	
	@Query("select new com.devsuperior.uri2611.DTO.MovieMinDTO(obj.id, obj.name) from Movie obj "
			+ "where obj.genre.description = :genreName" )
	List <MovieMinDTO> search2(String genreName);

}
