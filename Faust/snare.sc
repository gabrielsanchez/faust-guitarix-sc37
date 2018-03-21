FaustSnare : UGen
{
  *ar { | gain(-20.0), gate(0.0) |
      ^this.multiNew('audio', gain, gate)
  }

  *kr { | gain(-20.0), gate(0.0) |
      ^this.multiNew('control', gain, gate)
  } 

  name { ^"FaustSnare" }


  info { ^"Generated with Faust" }
}

