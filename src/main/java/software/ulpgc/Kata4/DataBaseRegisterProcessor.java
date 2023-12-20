package software.ulpgc.Kata4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseRegisterProcessor implements RegisterProcessor{
    @Override
    public Map<Integer, Integer> process(List<Register> registers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Register register: registers){
            int Key = register.Cores();
            result.put(Key,result.getOrDefault(Key,0)+1);
        }
        return result;
    }
}
