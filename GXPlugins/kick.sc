FaustKick : UGen
{
  *ar { | gate(0.0), gain(-20.0) |
      ^this.multiNew('audio', gate, gain)
  }

  *kr { | gate(0.0), gain(-20.0) |
      ^this.multiNew('control', gate, gain)
  } 

  name { ^"FaustKick" }


  info { ^"Generated with Faust" }
}

