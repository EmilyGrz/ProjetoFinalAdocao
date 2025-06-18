import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusAdocaoConverter implements Converter<String, StatusAdocao> {

    @Override
    public StatusAdocao convert(String source) {
        return StatusAdocao.fromValor(source);
    }
}
