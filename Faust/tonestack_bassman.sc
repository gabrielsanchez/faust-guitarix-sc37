FaustBassmanStyle : UGen
{
  *ar { | in1, amp_tonestack_bass(0.5), amp_tonestack_middle(0.5), amp_tonestack_treble(0.5) |
      ^this.multiNew('audio', in1, amp_tonestack_bass, amp_tonestack_middle, amp_tonestack_treble)
  }

  *kr { | in1, amp_tonestack_bass(0.5), amp_tonestack_middle(0.5), amp_tonestack_treble(0.5) |
      ^this.multiNew('control', in1, amp_tonestack_bass, amp_tonestack_middle, amp_tonestack_treble)
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

  name { ^"FaustBassmanStyle" }


  info { ^"Generated with Faust" }
}

