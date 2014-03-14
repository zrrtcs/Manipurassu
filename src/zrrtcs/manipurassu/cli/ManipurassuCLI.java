/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zrrtcs.manipurassu.cli;

//import org.jruby.embed.ScriptingContainer;

import org.jruby.embed.ScriptingContainer;


/**
 *
 * @author pzagmatic
 */
public class ManipurassuCLI {
    public static void main(String[] args) {
        String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
"tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        ScriptingContainer container = new ScriptingContainer();
        Object zxc = container.runScriptlet("puts \"jekomi\"");
        System.out.println("zxc: "+zxc);
        
    }
}
