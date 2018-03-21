FaustTom : UGen
{
  *ar { | gainf(-20.0), freq(90.0), gate(0.0) |
      ^this.multiNew('audio', gainf, freq, gate)
  }

  *kr { | gainf(-20.0), freq(90.0), gate(0.0) |
      ^this.multiNew('control', gainf, freq, gate)
  } 

  name { ^"FaustTom" }


  info { ^"Generated with Faust" }
}

