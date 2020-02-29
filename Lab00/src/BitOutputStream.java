
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream extends FileOutputStream{

    public BitOutputStream(File file) throws FileNotFoundException {
        super(file);
        // TODO Auto-generated constructor stub
    }
    
    public void writeBit(char bit) {
        //    write a bit '0' or '1' to the output stream as a byte
    	if (bit > 0 || bit <= 256) {
    		
    	}
        
    }
    
    public void writeBit(String bit) {
//        write a string of bits to the output as a byte. 
//        If there are more than one byte, you will need to write them all bytes.
    }
    
    @Override
    public void close() throws IOException {
//        if the byte is neither empty nor full, close() must fill zeros to make a 
//        full 8 bits in the byte and then outputs the byte and closes the stream.
    	super.close();
        
    }

}