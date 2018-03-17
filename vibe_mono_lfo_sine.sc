FaustVibeMonoLfoSine : UGen
{
  *ar { | univibe_mono_freq(4.4) |
      ^this.multiNew('audio', univibe_mono_freq)
  }

  *kr { | univibe_mono_freq(4.4) |
      ^this.multiNew('control', univibe_mono_freq)
  } 

  name { ^"FaustVibeMonoLfoSine" }


  info { ^"Generated with Faust" }
}

