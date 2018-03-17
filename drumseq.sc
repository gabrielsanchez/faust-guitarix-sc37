FaustDrumSequencer : UGen
{
  *ar { | in1, gain_0(-20.0), gain_1(-20.0), gate_0(0.0), gate_1(0.0), gain_2(-20.0), gain_3(-20.0), gate_2(0.0), gainf_2(-20.0), freq_2(90.0), gate_3(0.0) |
      ^this.multiNew('audio', in1, gain_0, gain_1, gate_0, gate_1, gain_2, gain_3, gate_2, gainf_2, freq_2, gate_3)
  }

  *kr { | in1, gain_0(-20.0), gain_1(-20.0), gate_0(0.0), gate_1(0.0), gain_2(-20.0), gain_3(-20.0), gate_2(0.0), gainf_2(-20.0), freq_2(90.0), gate_3(0.0) |
      ^this.multiNew('control', in1, gain_0, gain_1, gate_0, gate_1, gain_2, gain_3, gate_2, gainf_2, freq_2, gate_3)
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

  name { ^"FaustDrumSequencer" }


  info { ^"Generated with Faust" }
}

