package First_module_project.Services;

import java.nio.file.Path;

import static First_module_project.Services.Validators.directoryCheck;

public class FileService {

    public void readFiles (String inputFiles){
        Path path = Path.of(inputFiles);
        directoryCheck(path);
        

    }




    public void writeFiles (String outputFiles){
        Path path = Path.of(outputFiles);
        directoryCheck(path);

    }

}
