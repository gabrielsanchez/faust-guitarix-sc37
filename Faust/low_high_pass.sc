FaustLowHighFilter : UGen
{
  *ar { | in1, high_freq_0(5000.0), low_freq_0(130.0), on_off_0(0.0), high_freq_1(130.0), low_freq_1(5000.0), on_off_1(0.0) |
      ^this.multiNew('audio', in1, high_freq_0, low_freq_0, on_off_0, high_freq_1, low_freq_1, on_off_1)
  }

  *kr { | in1, high_freq_0(5000.0), low_freq_0(130.0), on_off_0(0.0), high_freq_1(130.0), low_freq_1(5000.0), on_off_1(0.0) |
      ^this.multiNew('control', in1, high_freq_0, low_freq_0, on_off_0, high_freq_1, low_freq_1, on_off_1)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustLowHighFilter" }


  info { ^"Generated with Faust" }
}

