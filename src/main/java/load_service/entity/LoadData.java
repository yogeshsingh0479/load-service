package load_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "load_data")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoadData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String loadName;
	Long order_id;
	String order_name;
}
