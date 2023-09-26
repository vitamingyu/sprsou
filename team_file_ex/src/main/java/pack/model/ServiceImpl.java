package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements MappingInterface {
	private final MappingInterface mappingInterface;

    public ServiceImpl(MappingInterface mappingInterface) {
        this.mappingInterface = mappingInterface;
    }

    @Override
    public void saveFile(VO vo) {
        mappingInterface.saveFile(vo);
    }
}
