FaustVibeLfoSine : MultiOutUGen
{
  *ar { | univibe_freq(4.4), univibe_stereo(0.11) |
      ^this.multiNew('audio', univibe_freq, univibe_stereo)
  }

  *kr { | univibe_freq(4.4), univibe_stereo(0.11) |
      ^this.multiNew('control', univibe_freq, univibe_stereo)
  } 

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustVibeLfoSine" }


  info { ^"Generated with Faust" }
}

