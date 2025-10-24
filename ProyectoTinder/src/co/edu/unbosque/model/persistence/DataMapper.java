package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.AdministradorDTO;
import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class DataMapper {

	public static AdministradorDTO convertirAdministradorAAdministradorDTO(Administrador entity) {
		AdministradorDTO dto = new AdministradorDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(),
				entity.getCorreo(), entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getCompanyia());
		return dto;
	}

	public static MujerDTO convertirMujerAMujerDTO(Mujer entity) {
		MujerDTO dto = new MujerDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(), entity.getCorreo(),
				entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getEdad(), entity.getEstatura(),
				entity.getFotoPerfil(), entity.getMeGusta(), entity.isEstaDisponible(), entity.getLugar(),
				entity.isEsHombre(), entity.isEstaDivorciada());
		return dto;
	}

	public static HombreDTO convertirHombreAHombreDTO(Hombre entity) {
		HombreDTO dto = new HombreDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(), entity.getCorreo(),
				entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getEdad(), entity.getEstatura(),
				entity.getFotoPerfil(), entity.getMeGusta(), entity.isEstaDisponible(), entity.getLugar(),
				entity.isEsHombre(), entity.getSalario());
		return dto;
	}

	public static Administrador convertirAdministradorDTOAAdministrador(AdministradorDTO dto) {
		Administrador entity = new Administrador(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
				dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getCompanyia());
		return entity;
	}

	public static Mujer convertirMujerDTOAMujer(MujerDTO dto) {
		Mujer entity = new Mujer(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
				dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getEdad(), dto.getEstatura(),
				dto.getFotoPerfil(), dto.getMeGusta(), dto.isEstaDisponible(), dto.getLugar(), dto.isEsHombre(),
				dto.isEstaDivorciada());
		return entity;
	}

	public static Hombre convertirHombreDTOAHombre(HombreDTO dto) {
		Hombre entity = new Hombre(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
				dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getEdad(), dto.getEstatura(),
				dto.getFotoPerfil(), dto.getMeGusta(), dto.isEstaDisponible(), dto.getLugar(), dto.isEsHombre(),
				dto.getSalario());
		return entity;
	}

	// LISTAS

	public static ArrayList<AdministradorDTO> convertirListaAdministradorAListaAdministradorDTO(
			ArrayList<Administrador> listaEntity) {
		ArrayList<AdministradorDTO> listaDTO = new ArrayList<>();
		for (Administrador entity : listaEntity) {
			AdministradorDTO dto = new AdministradorDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(),
					entity.getCorreo(), entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getCompanyia());
			listaDTO.add(dto);
		}
		return listaDTO;
	}

	public static ArrayList<MujerDTO> convertirListaMujerAListaMujerDTO(ArrayList<Mujer> listaEntity) {
		ArrayList<MujerDTO> listaDTO = new ArrayList<>();
		for (Mujer entity : listaEntity) {
			MujerDTO dto = new MujerDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(), entity.getCorreo(),
					entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getEdad(), entity.getEstatura(),
					entity.getFotoPerfil(), entity.getMeGusta(), entity.isEstaDisponible(), entity.getLugar(),
					entity.isEsHombre(), entity.isEstaDivorciada());
			listaDTO.add(dto);
		}
		return listaDTO;
	}

	public static ArrayList<HombreDTO> convertirListaHombreAListaHombreDTO(ArrayList<Hombre> listaEntity) {
		ArrayList<HombreDTO> listaDTO = new ArrayList<>();
		for (Hombre entity : listaEntity) {
			HombreDTO dto = new HombreDTO(entity.getNombre(), entity.getAlias(), entity.getCedula(), entity.getCorreo(),
					entity.getContrasenya(), entity.getCodigoVerificacion(), entity.getEdad(), entity.getEstatura(),
					entity.getFotoPerfil(), entity.getMeGusta(), entity.isEstaDisponible(), entity.getLugar(),
					entity.isEsHombre(), entity.getSalario());
			listaDTO.add(dto);
		}
		return listaDTO;
	}

	public static ArrayList<Administrador> convertirListaAdministradorDTOAListaAdministrador(
			ArrayList<AdministradorDTO> listaDTO) {
		ArrayList<Administrador> listaEntity = new ArrayList<>();
		for (AdministradorDTO dto : listaDTO) {
			Administrador entity = new Administrador(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
					dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getCompanyia());
			listaEntity.add(entity);
		}
		return listaEntity;
	}

	public static ArrayList<Mujer> convertirListaMujerDTOAListaMujer(ArrayList<MujerDTO> listaDTO) {
		ArrayList<Mujer> listaEntity = new ArrayList<>();
		for (MujerDTO dto : listaDTO) {
			Mujer entity = new Mujer(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
					dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getEdad(), dto.getEstatura(),
					dto.getFotoPerfil(), dto.getMeGusta(), dto.isEstaDisponible(), dto.getLugar(), dto.isEsHombre(),
					dto.isEstaDivorciada());
			listaEntity.add(entity);
		}
		return listaEntity;
	}

	public static ArrayList<Hombre> convertirListaHombreDTOAListaHombre(ArrayList<HombreDTO> listaDTO) {
		ArrayList<Hombre> listaEntity = new ArrayList<>();
		for (HombreDTO dto : listaDTO) {
			Hombre entity = new Hombre(dto.getNombre(), dto.getAlias(), dto.getCedula(), dto.getCorreo(),
					dto.getContrasenya(), dto.getCodigoVerificacion(), dto.getEdad(), dto.getEstatura(),
					dto.getFotoPerfil(), dto.getMeGusta(), dto.isEstaDisponible(), dto.getLugar(), dto.isEsHombre(),
					dto.getSalario());
			listaEntity.add(entity);
		}
		return listaEntity;
	}

}