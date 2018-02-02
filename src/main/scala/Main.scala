import java.io.{File, PrintWriter}

import com.auxilii.msgparser.MsgParser

object Main extends App {

  val inDir = "/home/keerathj/Downloads/100-files"
  val outDir = "/home/keerathj/Downloads/100-files-txt"

  val msgParser = new MsgParser


  new File(inDir).listFiles().par.foreach { file =>
    val name = file.getName
    val text = msgParser.parseMsg(file).getBodyText.replaceAll("\r\n", "\n")

    new PrintWriter(s"$outDir/$name.txt") {
      write(text)
      close()
    }
  }
}
