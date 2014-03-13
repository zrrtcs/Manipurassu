/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zrrtcs.manipurassu.rubymachine;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.jruby.embed.ScriptingContainer;

/**
 *
 * @author pzagmatic
 */
public class RubyMachine {
    ScriptingContainer container;
    StringWriter sw;
    PrintStream psOut;
    public RubyMachine(){
        container = new ScriptingContainer();
        sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        container.setWriter(pw);
    }
    public String helloWorld(){
        return (String)container.runScriptlet("\"hello world!\".reverse");  
    }
    public String fireRubyStringManipulator(String inputText, String rubyCode){
        String outputText="";
        return outputText;
    }
}
