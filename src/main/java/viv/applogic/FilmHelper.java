package viv.applogic;

import java.util.List;

import viv.model.Film;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	List<Film> search(String title);
}
